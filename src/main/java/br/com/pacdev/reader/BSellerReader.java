package br.com.pacdev.reader;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import Client.GatewayServiceClient;
import br.com.pacdev.enums.OrderStatus;
import br.com.pacdev.exception.TopLevelException;
import br.com.pacdev.object.customer.Customer;
import br.com.pacdev.object.order.Order;
import br.com.pacdev.util.HttpUtils;
import br.com.pacdev.util.XmlUtils;

public class BSellerReader {

	private String username = null;
	private String password = null;
	private String baseUrl = null;
	private String ecommerceName = null;

	private final String MAIN_URL = "https://%s/commerce-api/api/%s";
	private final String CUSTOMER_URL = "customer";
	private final String ORDER_URL = "order";
	private final String MAX_FILTER = "max=%d";
	private final String OFFSET_FILTER = "offset=%d";
	private final String OPTIN_FILTER = "optin=%s";
	private final String START_FILTER = "start=%s";
	private final String END_FILTER = "end=%s";
	private final String VERSION_FILTER = "version=%d";
	private final String STATUS_FILTER = "status=%s";

	private int times = 0;
	private int max = 0;
	public static int actualNumberOfCustomersRead = 0;
	public static int actualThreadNumber = 0;
	public static int actualThreadCompletedNumber = 0;
	public static int totalThreadsNumber = 0;
	public static Customer[] listCustomer;
	public static Order[] listOrder;

	public BSellerReader(String username, String password, String baseUrl) {
		super();
		this.username = username;
		this.password = password;
		this.baseUrl = baseUrl;
		this.times = 0;
		this.max = 0;
		BSellerReader.actualNumberOfCustomersRead = 0;
		BSellerReader.actualThreadNumber = 0;
		BSellerReader.actualThreadCompletedNumber = 0;
		BSellerReader.totalThreadsNumber = 0;
		BSellerReader.listCustomer = null;
		BSellerReader.listOrder = null;
	}


	/***
	 * This method allows you to retrieve a list of customers.
	 * @param max
	 * @param optin
	 * @return List of Customers
	 * @throws TopLevelException
	 */
	public Customer[] getCustomers(int max, Boolean optin) {
		long longIni = new Date().getTime();
		if(max <= 0) max = 999999;
		listCustomer = new Customer[max];

		System.out.println("Warning: long requests may cause problems if you get disconnected for a few seconds.");
		//Sets base URL for function customer
		String url = String.format(this.MAIN_URL, this.baseUrl, this.CUSTOMER_URL);
		//Set parameters base
		url = String.format(url + "?" + this.MAX_FILTER,max);
		if(optin != null) url = String.format(url + "&" + this.OPTIN_FILTER, optin.toString());
		url = url + "&" + OFFSET_FILTER;
		totalThreadsNumber = max/100;
		for(int i=0; i<max; i=i+100){
			this.actualThreadNumber++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String nextUrl = String.format(url, i);
			Thread thread = new Thread(new CustomerRunnable(nextUrl, max,username,password,this.baseUrl,i));
			thread.start();
			System.out.println(this.actualThreadNumber+" threads opened.");
		}

		while(totalThreadsNumber > actualThreadCompletedNumber){
			try {
				Thread.sleep(1000);
				System.out.println(String.format("(%d/%d) Customers",actualThreadCompletedNumber,totalThreadsNumber));
			} catch (InterruptedException e) {//FIXME
				e.printStackTrace();
			}
		}

		Customer[] o = listCustomer;
		listCustomer = new Customer[0];
		System.out.println("Time to extract all data: " + ((new Date().getTime()-longIni)/1000) + " seconds.");
		return o;
	}

	/***
	 * This method allows you to retrieve a list of orders throught a list of IDs.
	 * @param ID array
	 * @param version
	 * @return List of Order
	 * @throws TopLevelException
	 */
	public Order[] getOrders(String[] ordersId, int version) {
		long longIni = new Date().getTime();
		System.out.println("Warning: long requests may cause problems if you get disconnected for a few seconds.");

		if(ordersId.length > 0){
			totalThreadsNumber = ordersId.length;
			listOrder = new Order[ordersId.length];
			for(int i=0; i<ordersId.length; i++){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String nextUrl = String.format(MAIN_URL + "/%s", baseUrl, ORDER_URL, ordersId[i].trim());
				Thread thread = new Thread(new OrderRunnable(nextUrl, username, password, this.baseUrl, i));
				thread.start();
			}

			while(totalThreadsNumber > actualThreadCompletedNumber){
				try {
					Thread.sleep(3000);
					System.out.println(String.format("(%d/%d) Threads",actualThreadCompletedNumber,totalThreadsNumber));
				} catch (InterruptedException e) {//FIXME
					e.printStackTrace();
				}
			}
		}
		Order[] o = listOrder;
		listOrder = new Order[0];
		System.out.println("Time to extract all data: " + ((new Date().getTime()-longIni)/1000) + " seconds.");
		return o;
	}



	/***
	 * This method allows you to retrieve a list of orders through a range.
	 * @param Start Date (yyyy-mm-dd)
	 * @param End Date (yyyy-mm-dd)
	 * @param version
	 * @param status of orders
	 * @return List of Orders
	 * @throws TopLevelException
	 */
	public Order[] getOrders(String start, String end, int version, OrderStatus orderStatus) {
		long longIni = new Date().getTime();
		int max = 99999999;
		System.out.println("Warning: long requests may cause problems if you get disconnected for a few seconds.");
		//Sets base URL for function customer
		String mainUrl = String.format(this.MAIN_URL, this.baseUrl, this.ORDER_URL);

		//Parameters
		mainUrl = String.format(mainUrl + "?" + this.VERSION_FILTER,version);
		mainUrl = String.format(mainUrl + "&" + this.MAX_FILTER,max);
		mainUrl = String.format(mainUrl + "&" + this.START_FILTER,start);
		mainUrl = String.format(mainUrl + "&" + this.END_FILTER,end);
		if(orderStatus != null) mainUrl = String.format(mainUrl + "&" + this.STATUS_FILTER, orderStatus.getValue());

		Document d = null;
		try {
			d = HttpUtils.getInstance().getDocumentByURL(mainUrl,this.username,this.password,this.baseUrl);

			if(d != null){
				NodeList nl = XmlUtils.getInstance().getNodeListByXPath(d, "/orders/order/link");
				totalThreadsNumber = nl.getLength();
				listOrder = new Order[nl.getLength()];
				System.out.println("Total Threads Number:"+totalThreadsNumber);
				for(int i=0; i<nl.getLength(); i++){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					String nextUrl = String.format(nl.item(i).getTextContent().replaceFirst("http", "https") + "?" + VERSION_FILTER, version);
					Thread thread = new Thread(new OrderRunnable(nextUrl, username,password,this.baseUrl,i));
					thread.start();
				}

				while(totalThreadsNumber > actualThreadCompletedNumber){
					try {
						Thread.sleep(1000);
						System.out.println(String.format("(%d/%d) Threads",actualThreadCompletedNumber,totalThreadsNumber));
					} catch (InterruptedException e) {//FIXME
						e.printStackTrace();
					}
				}
			}

		} catch (IOException e1) {
			System.err.println("Failed to connect to main URL.");
		}
		Order[] o = listOrder;
		listOrder = new Order[0];
		System.out.println("Time to extract all data: " + ((new Date().getTime()-longIni)/1000) + " seconds.");
		return o;
	}


	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getEcommerceName() {
		return ecommerceName;
	}
	public void setEcommerceName(String ecommerceName) {
		this.ecommerceName = ecommerceName;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}




}
