package br.com.pacdev.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;

import br.com.pacdev.exception.UrlNotFoundException;

public class HttpUtils {
	private static HttpUtils INSTANCE;
	public static HttpUtils getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new HttpUtils();
		}
		return INSTANCE;
	}


	public Document getDocumentByURL(String url, String user, String password, String baseUrl) throws IOException, ClientProtocolException{
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(baseUrl, 443),
                new UsernamePasswordCredentials(user, password));
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		Document d = null;
		try {
			HttpGet httpget = new HttpGet(url);
			int CONNECTION_TIMEOUT_MS = 30 * 1000; // Timeout in millis.
			RequestConfig requestConfig = RequestConfig.custom()
			    .setConnectionRequestTimeout(CONNECTION_TIMEOUT_MS)
			    .setConnectTimeout(CONNECTION_TIMEOUT_MS)
			    .setSocketTimeout(CONNECTION_TIMEOUT_MS)
			    .build();

			httpget.setConfig(requestConfig);

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}

			};
			
			String responseBody = httpclient.execute(httpget, responseHandler);
			d = XmlUtils.getInstance().string2xml(responseBody);
		} finally {
			httpclient.close();
		}		
		return d;
	}
}
