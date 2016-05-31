
package br.com.pacdev.object.order;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Addresses {

    private Shipping shipping;
    private Billing billing;

    /**
     * 
     * @return
     *     The shipping
     */
    public Shipping getShipping() {
        return shipping;
    }

    /**
     * 
     * @param shipping
     *     The shipping
     */
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    /**
     * 
     * @return
     *     The billing
     */
    public Billing getBilling() {
        return billing;
    }

    /**
     * 
     * @param billing
     *     The billing
     */
    public void setBilling(Billing billing) {
        this.billing = billing;
    }

}
