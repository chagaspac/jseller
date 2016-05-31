
package br.com.pacdev.object.order;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Phone {

    private String ddd;
    private String number;

    /**
     * 
     * @return
     *     The ddd
     */
    public String getDdd() {
        return ddd;
    }

    /**
     * 
     * @param ddd
     *     The ddd
     */
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    /**
     * 
     * @return
     *     The number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 
     * @param number
     *     The number
     */
    public void setNumber(String number) {
        this.number = number;
    }

}
