
package br.com.pacdev.object.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Customer {

    private String id;
    private String externalId;
    private String isPhysicalPerson;
    private String name;
    private String nickName;
    private String document;
    private String email;
    private String optin;
    private List<String> tags = new ArrayList<String>();
    private String gender;
    private String birthdate;
    private Phone phone;
    private Phone cellphone;
    private List<String> customerTags = new ArrayList<String>();

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
     *     The externalId
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * 
     * @param externalId
     *     The externalId
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * 
     * @return
     *     The isPhysicalPerson
     */
    public String getIsPhysicalPerson() {
        return isPhysicalPerson;
    }

    /**
     * 
     * @param isPhysicalPerson
     *     The isPhysicalPerson
     */
    public void setIsPhysicalPerson(String isPhysicalPerson) {
        this.isPhysicalPerson = isPhysicalPerson;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 
     * @param nickName
     *     The nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 
     * @return
     *     The document
     */
    public String getDocument() {
        return document;
    }

    /**
     * 
     * @param document
     *     The document
     */
    public void setDocument(String document) {
        this.document = document;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The optin
     */
    public String getOptin() {
        return optin;
    }

    /**
     * 
     * @param optin
     *     The optin
     */
    public void setOptin(String optin) {
        this.optin = optin;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * 
     * @param birthdate
     *     The birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The cellphone
     */
    public Phone getCellphone() {
        return cellphone;
    }

    /**
     * 
     * @param cellphone
     *     The cellphone
     */
    public void setCellphone(Phone cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * 
     * @return
     *     The customerTags
     */
    public List<String> getCustomerTags() {
        return customerTags;
    }

    /**
     * 
     * @param customerTags
     *     The customerTags
     */
    public void setCustomerTags(List<String> customerTags) {
        this.customerTags = customerTags;
    }

}
