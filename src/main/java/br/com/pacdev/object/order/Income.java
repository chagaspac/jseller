
package br.com.pacdev.object.order;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Income {

    private String authorizationCode;
    private String authorizationMessage;

    /**
     * 
     * @return
     *     The authorizationCode
     */
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    /**
     * 
     * @param authorizationCode
     *     The authorizationCode
     */
    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    /**
     * 
     * @return
     *     The authorizationMessage
     */
    public String getAuthorizationMessage() {
        return authorizationMessage;
    }

    /**
     * 
     * @param authorizationMessage
     *     The authorizationMessage
     */
    public void setAuthorizationMessage(String authorizationMessage) {
        this.authorizationMessage = authorizationMessage;
    }

}
