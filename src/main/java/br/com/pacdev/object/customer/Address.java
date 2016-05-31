package br.com.pacdev.object.customer;

public class Address
{
    private Phone phone;

    private String street;

    private String zipcode;

    private String neighborhood;

    private String state;

    private String number;

    private String reference;

    private String city;

    private String complement;

    private String billing;

    private String shipping;
    
    private String contactName;

    private String name;

    public Phone getPhone ()
    {
        return phone;
    }

    public void setPhone (Phone phone)
    {
        this.phone = phone;
    }

    public String getStreet ()
    {
        return street;
    }

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getZipcode ()
    {
        return zipcode;
    }

    public void setZipcode (String zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getNeighborhood ()
    {
        return neighborhood;
    }

    public void setNeighborhood (String neighborhood)
    {
        this.neighborhood = neighborhood;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    public String getReference ()
    {
        return reference;
    }

    public void setReference (String reference)
    {
        this.reference = reference;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getComplement ()
    {
        return complement;
    }

    public void setComplement (String complement)
    {
        this.complement = complement;
    }

    public String getBilling ()
    {
        return billing;
    }

    public void setBilling (String billing)
    {
        this.billing = billing;
    }

    public String getShipping ()
    {
        return shipping;
    }

    public void setShipping (String shipping)
    {
        this.shipping = shipping;
    }

    public String getContactName ()
    {
        return contactName;
    }

    public void setContactName (String contactName)
    {
        this.contactName = contactName;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [phone = "+phone+", street = "+street+", zipcode = "+zipcode+", neighborhood = "+neighborhood+", state = "+state+", number = "+number+", reference = "+reference+", city = "+city+", complement = "+complement+", billing = "+billing+", shipping = "+shipping+", contactName = "+contactName+", name = "+name+"]";
    }
}
			