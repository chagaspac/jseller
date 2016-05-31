package br.com.pacdev.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.pacdev.object.order.Addresses;
import br.com.pacdev.object.order.Bill;
import br.com.pacdev.object.order.Billing;
import br.com.pacdev.object.order.Cart;
import br.com.pacdev.object.order.CreditCard;
import br.com.pacdev.object.order.Customer;
import br.com.pacdev.object.order.Delivery;
import br.com.pacdev.object.order.Freight;
import br.com.pacdev.object.order.Income;
import br.com.pacdev.object.order.Order;
import br.com.pacdev.object.order.OrderLine;
import br.com.pacdev.object.order.Payment;
import br.com.pacdev.object.order.Phone;
import br.com.pacdev.object.order.Shipping;
import br.com.pacdev.object.order.Utm;
import br.com.pacdev.util.HttpUtils;
import br.com.pacdev.util.XmlUtils;

public class OrderRunnable implements Runnable{

	private String url = null;
	private int timesTried = 0;
	private final int MAX_TIMES = 5;
	private String user=null;
	private String password=null;
	private String baseUrl=null;
	private int index=0;

	public OrderRunnable(String url, String user, String password, String baseUrl, int index) {
		super();
		this.url = url;
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
				NodeList nl = XmlUtils.getInstance().getNodeListByXPath(d, "/order");
				if(nl != null && nl.getLength() > 0){
					Order o = this.getOrderByElement((Element)nl.item(0));
					BSellerReader.listOrder[index] = o;
					BSellerReader.actualNumberOfCustomersRead++;
				}else{
					System.err.println(url + " - " + "NodeList empty");
				}
			}else{
				System.err.println(url + " - " + "Document Null");
			}
			BSellerReader.actualThreadCompletedNumber++;
		} catch (ClientProtocolException e) {
			if(e.getMessage().contains("404")){
				System.out.println(url + " - " + e.getMessage() + " - Thread Finished");
				BSellerReader.actualThreadCompletedNumber++;
			}else{
				System.out.println(url + " - " + e.getMessage() + " - Starting thread again");
				run();
			}
		} catch (IOException e) {
			if(e.getMessage().contains("404")){
				System.out.println(url + " - " + e.getMessage() + " - Thread Finished");
				BSellerReader.actualThreadCompletedNumber++;
			}else{
				System.out.println(url + " - " + e.getMessage() + " - Starting thread again");
				run();
			}
		} catch (NullPointerException e) {
			System.out.println(url + " - " + "Nullpointer: " + e.getMessage());
			run();
		}

	}

	private Order getOrderByElement(Element e){
		Order order = new Order();

		order.setId(XmlUtils.getInstance().getStringByXPath(e, "id"));
		order.setDateCreated(XmlUtils.getInstance().getStringByXPath(e, "dateCreated"));
		order.setLastUpdated(XmlUtils.getInstance().getStringByXPath(e, "lastUpdated"));
		order.setStatus(XmlUtils.getInstance().getStringByXPath(e, "status"));
		order.setConsumptionType(XmlUtils.getInstance().getStringByXPath(e, "consumptionType"));
		order.setSaleChannel(XmlUtils.getInstance().getStringByXPath(e, "saleChannel"));
		order.setAccessType(XmlUtils.getInstance().getStringByXPath(e, "accessType"));
		order.setInternalId(XmlUtils.getInstance().getStringByXPath(e, "internalId"));
		order.setIsGiftNFe(XmlUtils.getInstance().getStringByXPath(e, "isGiftNFe"));

		Addresses addresses = new Addresses();
		Billing billing = new Billing();
		billing.setId(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/id"));
		billing.setContactName(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/contactName"));
		billing.setAddressName(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/addressName"));
		billing.setAddress(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/address"));
		billing.setNumber(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/number"));
		billing.setProvince(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/province"));
		billing.setComplement(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/complement"));
		billing.setCity(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/city"));
		billing.setState(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/state"));
		billing.setZipcode(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/zipcode"));
		billing.setReference(XmlUtils.getInstance().getStringByXPath(e, "addresses/billing/reference"));

		Shipping shipping = new Shipping();
		shipping.setId(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/id"));
		shipping.setContactName(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/contactName"));
		shipping.setAddressName(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/addressName"));
		shipping.setAddress(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/address"));
		shipping.setNumber(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/number"));
		shipping.setProvince(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/province"));
		shipping.setComplement(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/complement"));
		shipping.setCity(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/city"));
		shipping.setState(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/state"));
		shipping.setZipcode(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/zipcode"));
		shipping.setReference(XmlUtils.getInstance().getStringByXPath(e, "addresses/shipping/reference"));

		addresses.setBilling(billing);
		addresses.setShipping(shipping);
		order.setAddresses(addresses);

		Cart cart = new Cart();
		cart.setCartId(XmlUtils.getInstance().getStringByXPath(e, "cart/cartId"));
		cart.setTotalDiscountAmount(XmlUtils.getInstance().getStringByXPath(e, "cart/totalDiscountAmount"));
		cart.setTotalInterestAmount(XmlUtils.getInstance().getStringByXPath(e, "cart/totalInterestAmount"));
		cart.setTotalAmount(XmlUtils.getInstance().getStringByXPath(e, "cart/totalAmount"));

		Freight freight = new Freight();
		freight.setTime(XmlUtils.getInstance().getStringByXPath(e, "cart/freight/time"));
		freight.setAmount(XmlUtils.getInstance().getStringByXPath(e, "cart/freight/amount"));
		freight.setDiscount(XmlUtils.getInstance().getStringByXPath(e, "cart/freight/discount"));
		freight.setTotalAmount(XmlUtils.getInstance().getStringByXPath(e, "cart/freight/totalAmount"));
		cart.setFreight(freight);

		NodeList nlOrderLines = XmlUtils.getInstance().getNodeListByXPath(e, "cart/orderLines/orderLine");
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		for(int j=0; j<nlOrderLines.getLength(); j++){
			OrderLine orderLine = new OrderLine();
			Element eOrderLine = (Element)nlOrderLines.item(j);

			orderLine.setIsVirtual(XmlUtils.getInstance().getStringByXPath(eOrderLine, "isVirtual"));
			orderLine.setItemId(XmlUtils.getInstance().getStringByXPath(eOrderLine, "itemId"));
			orderLine.setName(XmlUtils.getInstance().getStringByXPath(eOrderLine, "name"));
			orderLine.setSkuId(XmlUtils.getInstance().getStringByXPath(eOrderLine, "skuId"));
			orderLine.setProductId(XmlUtils.getInstance().getStringByXPath(eOrderLine, "productId"));
			orderLine.setQuantity(XmlUtils.getInstance().getStringByXPath(eOrderLine, "quantity"));
			orderLine.setAggregationOwner(XmlUtils.getInstance().getStringByXPath(eOrderLine, "aggregationOwner"));
			orderLine.setIsWarranty(XmlUtils.getInstance().getStringByXPath(eOrderLine, "isWarranty"));
			orderLine.setIsKit(XmlUtils.getInstance().getStringByXPath(eOrderLine, "isKit"));
			orderLine.setListPrice(XmlUtils.getInstance().getStringByXPath(eOrderLine, "listPrice"));
			orderLine.setSalePrice(XmlUtils.getInstance().getStringByXPath(eOrderLine, "salePrice"));
			orderLine.setDiscount(XmlUtils.getInstance().getStringByXPath(eOrderLine, "discount"));
			orderLine.setTotalAmount(XmlUtils.getInstance().getStringByXPath(eOrderLine, "totalAmount"));
			orderLine.setFreightTime(XmlUtils.getInstance().getStringByXPath(eOrderLine, "freightTime"));
			orderLine.setFreight(XmlUtils.getInstance().getStringByXPath(eOrderLine, "freight"));
			orderLine.setFreightDiscount(XmlUtils.getInstance().getStringByXPath(eOrderLine, "freightDiscount"));
			orderLine.setPickupLeadTime(XmlUtils.getInstance().getStringByXPath(eOrderLine, "pickupLeadTime"));
			orderLine.setLeadTime(XmlUtils.getInstance().getStringByXPath(eOrderLine, "leadTime"));
			orderLine.setVariation(XmlUtils.getInstance().getStringByXPath(eOrderLine, "variation"));
			orderLines.add(orderLine);
		}
		cart.setOrderLines(orderLines);
		order.setCart(cart);

		Customer customer = new Customer();
		customer.setId(XmlUtils.getInstance().getStringByXPath(e, "customer/id"));
		customer.setExternalId(XmlUtils.getInstance().getStringByXPath(e, "customer/externalId"));
		customer.setIsPhysicalPerson(XmlUtils.getInstance().getStringByXPath(e, "customer/isPhysicalPerson"));
		customer.setName(XmlUtils.getInstance().getStringByXPath(e, "customer/name"));
		customer.setNickName(XmlUtils.getInstance().getStringByXPath(e, "customer/nickName"));
		customer.setDocument(XmlUtils.getInstance().getStringByXPath(e, "customer/document"));
		customer.setEmail(XmlUtils.getInstance().getStringByXPath(e, "customer/email"));
		customer.setOptin(XmlUtils.getInstance().getStringByXPath(e, "customer/optin"));
		customer.setGender(XmlUtils.getInstance().getStringByXPath(e, "customer/gender"));
		customer.setBirthdate(XmlUtils.getInstance().getStringByXPath(e, "customer/birthdate"));

		Phone phone = new Phone();
		phone.setDdd(XmlUtils.getInstance().getStringByXPath(e, "customer/phone/ddd"));
		phone.setNumber(XmlUtils.getInstance().getStringByXPath(e, "customer/phone/number"));
		customer.setPhone(phone);

		Phone cellphone = new Phone();
		cellphone.setDdd(XmlUtils.getInstance().getStringByXPath(e, "customer/cellphone/ddd"));
		cellphone.setNumber(XmlUtils.getInstance().getStringByXPath(e, "customer/cellphone/number"));
		customer.setCellphone(cellphone);

		NodeList nlTags = XmlUtils.getInstance().getNodeListByXPath(e, "customer/tags/tag");
		List<String> tags = new ArrayList<String>();
		for(int j=0; j<nlTags.getLength(); j++){
			tags.add(nlTags.item(j).getTextContent());
		}
		customer.setTags(tags);

		NodeList nlCustomerTags = XmlUtils.getInstance().getNodeListByXPath(e, "customer/customerTags/customerTag/name");
		List<String> customerTags = new ArrayList<String>();
		for(int j=0; j<nlCustomerTags.getLength(); j++){
			customerTags.add(nlCustomerTags.item(j).getTextContent());
		}
		customer.setCustomerTags(customerTags);
		order.setCustomer(customer);

		NodeList nlDeliveries = XmlUtils.getInstance().getNodeListByXPath(e, "deliveries/delivery");
		List<Delivery> deliveries = new ArrayList<Delivery>();
		for(int j=0; j<nlDeliveries.getLength(); j++){
			Delivery delivery = new Delivery();
			Element eDelivery = (Element)nlDeliveries.item(j);

			delivery.setDeliveryType(XmlUtils.getInstance().getStringByXPath(eDelivery, "deliveryType"));
			delivery.setEstimate(XmlUtils.getInstance().getStringByXPath(eDelivery, "estimate"));
			delivery.setPrice(XmlUtils.getInstance().getStringByXPath(eDelivery, "price"));
			delivery.setTrackingCode(XmlUtils.getInstance().getStringByXPath(eDelivery, "trackingCode"));

			deliveries.add(delivery);
		}

		order.setDeliveries(deliveries);

		NodeList nlOrderTags = XmlUtils.getInstance().getNodeListByXPath(e, "orderTags/orderTag/name");
		List<String> orderTags = new ArrayList<String>();
		for(int j=0; j<nlOrderTags.getLength(); j++){
			orderTags.add(nlOrderTags.item(j).getTextContent());
		}
		order.setOrderTags(orderTags);

		NodeList nlPayments = XmlUtils.getInstance().getNodeListByXPath(e, "payments/payment");
		List<Payment> payments = new ArrayList<Payment>();
		for(int j=0; j<nlPayments.getLength(); j++){
			Payment payment = new Payment();
			Element ePayment = (Element)nlPayments.item(j);

			payment.setId(XmlUtils.getInstance().getStringByXPath(ePayment, "id"));
			payment.setType(XmlUtils.getInstance().getStringByXPath(ePayment, "type"));
			payment.setPaymentType(XmlUtils.getInstance().getStringByXPath(ePayment, "paymentType"));
			payment.setGateway(XmlUtils.getInstance().getStringByXPath(ePayment, "gateway"));
			payment.setToken(XmlUtils.getInstance().getStringByXPath(ePayment, "token"));
			payment.setTransactionId(XmlUtils.getInstance().getStringByXPath(ePayment, "transactionId"));
			payment.setAmount(XmlUtils.getInstance().getStringByXPath(ePayment, "amount"));
			payment.setSequencialNumber(XmlUtils.getInstance().getStringByXPath(ePayment, "sequencialNumber"));
			CreditCard creditCard = new CreditCard();
			creditCard.setParcels(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/parcels"));
			creditCard.setInterestRate(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/interestRate"));
			creditCard.setInterestAmount(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/interestAmount"));
			creditCard.setTotalAmount(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/totalAmount"));
			creditCard.setBinNumber(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/binNumber"));
			creditCard.setBrand(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/brand"));
			creditCard.setOwnerName(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/ownerName"));
			creditCard.setNumber(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/number"));
			creditCard.setPin(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/pin"));
			creditCard.setExpirationDate(XmlUtils.getInstance().getStringByXPath(ePayment, "creditCard/expirationDate"));
			payment.setCreditCard(creditCard);
			Income income = new Income();
			income.setAuthorizationCode(XmlUtils.getInstance().getStringByXPath(ePayment, "income/authorizationCode"));
			income.setAuthorizationMessage(XmlUtils.getInstance().getStringByXPath(ePayment, "income/authorizationMessage"));
			payment.setIncome(income);
			Bill bill = new Bill();
			bill.setRedirectUrl(XmlUtils.getInstance().getStringByXPath(ePayment, "bill/redirectUrl"));
			payment.setBill(bill);


			NodeList nlPaymentProps = XmlUtils.getInstance().getNodeListByXPath(ePayment, "paymentProps/prop");
			Map<String,String> paymentProps = new HashMap<String,String>();
			for(int k=0; k<nlPaymentProps.getLength(); k++){
				Element ePaymentProp = (Element)nlPaymentProps.item(k);
				paymentProps.put(XmlUtils.getInstance().getStringByXPath(ePaymentProp, "key"),
						XmlUtils.getInstance().getStringByXPath(ePaymentProp, "value")
						);
			}
			payment.setPaymentProps(paymentProps);
			payments.add(payment);
		}
		order.setPayments(payments);
		
		
		Utm utm = new Utm();
		utm.setUtmSource(XmlUtils.getInstance().getStringByXPath(e, "utm/utmSource"));
		utm.setUtmMedium(XmlUtils.getInstance().getStringByXPath(e, "utm/utmMedium"));
		utm.setUtmTerm(XmlUtils.getInstance().getStringByXPath(e, "utm/utmTerm"));
		utm.setUtmContent(XmlUtils.getInstance().getStringByXPath(e, "utm/utmContent"));
		utm.setUtmCampaign(XmlUtils.getInstance().getStringByXPath(e, "utm/utmCampaign"));
		order.setUtm(utm);

		return order;
	}
}
