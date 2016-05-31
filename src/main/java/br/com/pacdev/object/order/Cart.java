
package br.com.pacdev.object.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Cart {

    private String cartId;
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();
    private Freight freight;
    private String totalDiscountAmount;
    private String totalInterestAmount;
    private String totalAmount;

    /**
     * 
     * @return
     *     The cartId
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * 
     * @param cartId
     *     The cartId
     */
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    /**
     * 
     * @return
     *     The orderLines
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * 
     * @param orderLines
     *     The orderLines
     */
    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    /**
     * 
     * @return
     *     The freight
     */
    public Freight getFreight() {
        return freight;
    }

    /**
     * 
     * @param freight
     *     The freight
     */
    public void setFreight(Freight freight) {
        this.freight = freight;
    }

    /**
     * 
     * @return
     *     The totalDiscountAmount
     */
    public String getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    /**
     * 
     * @param totalDiscountAmount
     *     The totalDiscountAmount
     */
    public void setTotalDiscountAmount(String totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    /**
     * 
     * @return
     *     The totalInterestAmount
     */
    public String getTotalInterestAmount() {
        return totalInterestAmount;
    }

    /**
     * 
     * @param totalInterestAmount
     *     The totalInterestAmount
     */
    public void setTotalInterestAmount(String totalInterestAmount) {
        this.totalInterestAmount = totalInterestAmount;
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
