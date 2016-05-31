
package br.com.pacdev.object.order;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Delivery {

    private String deliveryType;
    private String estimate;
    private String price;
    private String trackingCode;

    /**
     * 
     * @return
     *     The deliveryType
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    /**
     * 
     * @param deliveryType
     *     The deliveryType
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * 
     * @return
     *     The estimate
     */
    public String getEstimate() {
        return estimate;
    }

    /**
     * 
     * @param estimate
     *     The estimate
     */
    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    /**
     * 
     * @return
     *     The price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The trackingCode
     */
    public String getTrackingCode() {
        return trackingCode;
    }

    /**
     * 
     * @param trackingCode
     *     The trackingCode
     */
    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

}
