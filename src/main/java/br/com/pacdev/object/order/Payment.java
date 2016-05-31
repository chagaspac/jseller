
package br.com.pacdev.object.order;

import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Payment {

    private String id;
    private String type;
    private String paymentType;
    private String gateway;
    private String token;
    private String transactionId;
    private String sequencialNumber;
    private String amount;
    private CreditCard creditCard;
    private Income income;
    private Bill bill;
    private Map<String,String> paymentProps;

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
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * 
     * @param paymentType
     *     The paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 
     * @return
     *     The gateway
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * 
     * @param gateway
     *     The gateway
     */
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    /**
     * 
     * @return
     *     The token
     */
    public String getToken() {
        return token;
    }

    /**
     * 
     * @param token
     *     The token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 
     * @return
     *     The transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 
     * @param transactionId
     *     The transactionId
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 
     * @return
     *     The sequencialNumber
     */
    public String getSequencialNumber() {
        return sequencialNumber;
    }

    /**
     * 
     * @param sequencialNumber
     *     The sequencialNumber
     */
    public void setSequencialNumber(String sequencialNumber) {
        this.sequencialNumber = sequencialNumber;
    }

    /**
     * 
     * @return
     *     The creditCard
     */
    public CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * 
     * @param creditCard
     *     The creditCard
     */
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * 
     * @return
     *     The paymentProps
     */
    public Map<String,String> getPaymentProps() {
        return paymentProps;
    }

    /**
     * 
     * @param paymentProps
     *     The paymentProps
     */
    public void setPaymentProps(Map<String,String> paymentProps) {
        this.paymentProps = paymentProps;
    }

    /**
     * 
     * @return
     *     The amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount
     *     The amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 
     * @return
     *     The income
     */
    public Income getIncome() {
        return income;
    }

    /**
     * 
     * @param income
     *     The income
     */
    public void setIncome(Income income) {
        this.income = income;
    }

    /**
     * 
     * @return
     *     The bill
     */
    public Bill getBill() {
        return bill;
    }

    /**
     * 
     * @param bill
     *     The bill
     */
    public void setBill(Bill bill) {
        this.bill = bill;
    }

}
