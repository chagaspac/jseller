
package br.com.pacdev.object.order;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Freight {

    private String time;
    private String amount;
    private String discount;
    private String totalAmount;

    /**
     * 
     * @return
     *     The time
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(String time) {
        this.time = time;
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
     *     The discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * 
     * @param discount
     *     The discount
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * 
     * @return
     *     The totalAmount
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * 
     * @param totalAmount
     *     The totalAmount
     */
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

}
