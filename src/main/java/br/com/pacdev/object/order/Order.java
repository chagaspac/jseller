
package br.com.pacdev.object.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Order {

    private String dateCreated;
    private String lastUpdated;
    private String status;
    private String consumptionType;
    private String saleChannel;
    private String accessType;
    private String internalId;
    private String isGiftNFe;
    private Addresses addresses;
    private Cart cart;
    private Customer customer;
    private List<Delivery> deliveries = new ArrayList<Delivery>();
    private List<String> orderTags = new ArrayList<String>();
    private List<Payment> payments = new ArrayList<Payment>();
    private String id;
    private Utm utm;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * 
     * @param dateCreated
     *     The dateCreated
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * 
     * @return
     *     The lastUpdated
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * 
     * @param lastUpdated
     *     The lastUpdated
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The consumptionType
     */
    public String getConsumptionType() {
        return consumptionType;
    }

    /**
     * 
     * @param consumptionType
     *     The consumptionType
     */
    public void setConsumptionType(String consumptionType) {
        this.consumptionType = consumptionType;
    }

    /**
     * 
     * @return
     *     The saleChannel
     */
    public String getSaleChannel() {
        return saleChannel;
    }

    /**
     * 
     * @param saleChannel
     *     The saleChannel
     */
    public void setSaleChannel(String saleChannel) {
        this.saleChannel = saleChannel;
    }

    /**
     * 
     * @return
     *     The accessType
     */
    public String getAccessType() {
        return accessType;
    }

    /**
     * 
     * @param accessType
     *     The accessType
     */
    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    /**
     * 
     * @return
     *     The orderTags
     */
    public List<String> getOrderTags() {
        return orderTags;
    }

    /**
     * 
     * @param orderTags
     *     The orderTags
     */
    public void setOrderTags(List<String> orderTags) {
        this.orderTags = orderTags;
    }

    /**
     * 
     * @return
     *     The internalId
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 
     * @param internalId
     *     The internalId
     */
    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    /**
     * 
     * @return
     *     The isGiftNFe
     */
    public String getIsGiftNFe() {
        return isGiftNFe;
    }

    /**
     * 
     * @param isGiftNFe
     *     The isGiftNFe
     */
    public void setIsGiftNFe(String isGiftNFe) {
        this.isGiftNFe = isGiftNFe;
    }

    /**
     * 
     * @return
     *     The customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * 
     * @param customer
     *     The customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * 
     * @return
     *     The addresses
     */
    public Addresses getAddresses() {
        return addresses;
    }

    /**
     * 
     * @param addresses
     *     The addresses
     */
    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    /**
     * 
     * @return
     *     The cart
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * 
     * @param cart
     *     The cart
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * 
     * @return
     *     The deliveries
     */
    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    /**
     * 
     * @param deliveries
     *     The deliveries
     */
    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    /**
     * 
     * @return
     *     The payments
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * 
     * @param payments
     *     The payments
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    /**
     * 
     * @return
     *     The utm
     */
    public Utm getUtm() {
        return utm;
    }

    /**
     * 
     * @param utm
     *     The utm
     */
    public void setUtm(Utm utm) {
        this.utm = utm;
    }


}
