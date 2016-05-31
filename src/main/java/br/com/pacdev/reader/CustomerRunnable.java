package br.com.pacdev.reader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.pacdev.exception.UrlNotFoundException;
import br.com.pacdev.object.customer.Address;
import br.com.pacdev.object.customer.Customer;
import br.com.pacdev.object.customer.Phone;
import br.com.pacdev.util.HttpUtils;
import br.com.pacdev.util.XmlUtils;

public class CustomerRunnable implements Runnable{

	private String url = null;
	private int max = 0;
	private int timesTried = 0;
	private final int MAX_TIMES = 5;
	private String user=null;
	private String password=null;
	private String baseUrl=null;
	private int index=0;

	public CustomerRunnable(String url, int max, String user, String password, String baseUrl, int index) {
		super();
		this.url = url;
		this.max = max;
		this.user = user;
		this.password = password;
		this.baseUrl = baseUrl;
		this.index = index;
	}



	@Override
	public void run() {		
		Document d = null;
		try {
			d = HttpUtils.getInstance().getDocumentByURL(url,user,password,baseUrl);
			if(d != null){
				NodeList nl = XmlUtils.getInstance().getNodeListByXPath(d, "/customers/customer");
				if(nl != null){
					if(nl.getLength() != 100) System.out.println(url + " - QTY of Customers:"+nl.getLength());
					for(int j=0; j<nl.getLength(); j++){
						Customer c = this.getCustomerByElement((Element)nl.item(j));
						BSellerReader.listCustomer[j+index] = c;
						BSellerReader.actualNumberOfCustomersRead++;
					}
				}
			}else{
				System.err.println("Document Null");
			}
			BSellerReader.actualThreadNumber--;
			BSellerReader.actualThreadCompletedNumber++;
		} catch (ClientProtocolException e) {
			if(e.getMessage().contains("404")){
				System.out.println(url + " - " + e.getMessage() + " - Thread Finished");
				BSellerReader.actualThreadNumber--;
				BSellerReader.actualThreadCompletedNumber++;
			}else{
				System.out.println(url + " - " + e.getMessage() + " - Starting thread again");
				run();
			}
		} catch (IOException e) {
			if(e.getMessage().contains("404")){
				System.out.println(url + " - " + e.getMessage() + " - Thread Finished");
				BSellerReader.actualThreadNumber--;
				BSellerReader.actualThreadCompletedNumber++;
			}else{
				System.out.println(url + " - " + e.getMessage() + " - Starting thread again");
				run();
			}
		} catch (NullPointerException e) {
			System.out.println(url + " - " + "Nullpointer: " + e.getMessage());
		}

	}


	private Customer getCustomerByElement(Element e){
		Customer c = new Customer();
		c.setId(XmlUtils.getInstance().getStringByXPath(e, "id"));
		c.setExternalId(XmlUtils.getInstance().getStringByXPath(e, "externalId"));
		c.setGender(XmlUtils.getInstance().getStringByXPath(e, "gender"));
		c.setBirthdate(XmlUtils.getInstance().getStringByXPath(e, "birthdate"));
		c.setName(XmlUtils.getInstance().getStringByXPath(e, "name"));
		c.setNick(XmlUtils.getInstance().getStringByXPath(e, "nick"));
		c.setEmail(XmlUtils.getInstance().getStringByXPath(e, "email"));
		c.setDocumentNumber(XmlUtils.getInstance().getStringByXPath(e, "documentNumber"));
		c.setOptin(XmlUtils.getInstance().getStringByXPath(e, "optin"));
		c.setComment(XmlUtils.getInstance().getStringByXPath(e, "comment"));

		Phone phone = new Phone();
		phone.setAreaCode(XmlUtils.getInstance().getStringByXPath(e, "phone/areaCode"));
		phone.setNumber(XmlUtils.getInstance().getStringByXPath(e, "phone/number"));
		c.setPhone(phone);

		Phone cellPhone = new Phone();
		cellPhone.setAreaCode(XmlUtils.getInstance().getStringByXPath(e, "cellPhone/areaCode"));
		cellPhone.setNumber(XmlUtils.getInstance().getStringByXPath(e, "cellPhone/number"));
		c.setCellPhone(cellPhone);

		Phone commercialPhone = new Phone();
		commercialPhone.setAreaCode(XmlUtils.getInstance().getStringByXPath(e, "commercialPhone/areaCode"));
		commercialPhone.setNumber(XmlUtils.getInstance().getStringByXPath(e, "commercialPhone/number"));
		c.setCommercialPhone(commercialPhone);

		NodeList nlAddresses = XmlUtils.getInstance().getNodeListByXPath(e, "addresses/address");
		List<Address> lAddress = new ArrayList<Address>();
		for(int j=0; j<nlAddresses.getLength(); j++){
			Element eAddress = (Element)nlAddresses.item(j);
			Address a = new Address();

			a.setContactName(XmlUtils.getInstance().getStringByXPath(eAddress, "contactName"));
			a.setName(XmlUtils.getInstance().getStringByXPath(eAddress, "name"));
			a.setStreet(XmlUtils.getInstance().getStringByXPath(eAddress, "street"));
			a.setNumber(XmlUtils.getInstance().getStringByXPath(eAddress, "number"));
			a.setNeighborhood(XmlUtils.getInstance().getStringByXPath(eAddress, "neighborhood"));
			a.setComplement(XmlUtils.getInstance().getStringByXPath(eAddress, "complement"));
			a.setCity(XmlUtils.getInstance().getStringByXPath(eAddress, "city"));
			a.setState(XmlUtils.getInstance().getStringByXPath(eAddress, "state"));
			a.setZipcode(XmlUtils.getInstance().getStringByXPath(eAddress, "zipcode"));
			a.setReference(XmlUtils.getInstance().getStringByXPath(eAddress, "reference"));
			a.setShipping(XmlUtils.getInstance().getStringByXPath(eAddress, "shipping"));
			a.setBilling(XmlUtils.getInstance().getStringByXPath(eAddress, "billing"));

			Phone aPhone = new Phone();
			aPhone.setAreaCode(XmlUtils.getInstance().getStringByXPath(eAddress, "phone/areaCode"));
			aPhone.setNumber(XmlUtils.getInstance().getStringByXPath(eAddress, "phone/number"));
			a.setPhone(aPhone);

			lAddress.add(a);
		}
		c.setAddresses(lAddress);		
		
		NodeList nlTags = XmlUtils.getInstance().getNodeListByXPath(e, "tags/tag");
		List<String> lTag = new ArrayList<String>();
		for(int j=0; j<nlTags.getLength(); j++){
			lTag.add(nlTags.item(j).getTextContent());
		}
		c.setTags(lTag);		
		
		
		return c;
	}

}
