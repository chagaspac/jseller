package br.com.pacdev.object.customer;

import java.util.List;

public class Customer
{
    private Phone phone;

    private Phone cellPhone;

    private String optin;

    private String externalId;

    private String id;

    private Phone commercialPhone;

    private String nick;

    private String email;

    private String name;

    private String birthdate;

    private String gender;

    private String documentNumber;

    private List<Address> addresses;

    private String comment;

    private List<String> tags;
    
	public Phone getPhone ()
    {
        return phone;
    }

    public void setPhone (Phone phone)
    {
        this.phone = phone;
    }

    public Phone getCellPhone ()
    {
        return cellPhone;
    }

    public void setCellPhone (Phone cellPhone)
    {
        this.cellPhone = cellPhone;
    }

    public String getOptin ()
    {
        return optin;
    }

    public void setOptin (String optin)
    {
        this.optin = optin;
    }

    public String getExternalId ()
    {
        return externalId;
    }

    public void setExternalId (String externalId)
    {
        this.externalId = externalId;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Phone getCommercialPhone ()
    {
        return commercialPhone;
    }

    public void setCommercialPhone (Phone commercialPhone)
    {
        this.commercialPhone = commercialPhone;
    }

    public String getNick ()
    {
        return nick;
    }

    public void setNick (String nick)
    {
        this.nick = nick;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getBirthdate ()
    {
        return birthdate;
    }

    public void setBirthdate (String birthdate)
    {
        this.birthdate = birthdate;
    }

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

    public String getDocumentNumber ()
    {
        return documentNumber;
    }

    public void setDocumentNumber (String documentNumber)
    {
        this.documentNumber = documentNumber;
    }

    public List<Address> getAddresses ()
    {
        return addresses;
    }

    public void setAddresses (List<Address> addresses)
    {
        this.addresses = addresses;
    }

    public String getComment ()
    {
        return comment;
    }

    public void setComment (String comment)
    {
        this.comment = comment;
    }

    @Override
    public String toString()
    {
        return "Customer - [phone = "+phone+", cellPhone = "+cellPhone+", optin = "+optin+", externalId = "+externalId+", id = "+id+", commercialPhone = "+commercialPhone+", nick = "+nick+", email = "+email+", name = "+name+", birthdate = "+birthdate+", gender = "+gender+", documentNumber = "+documentNumber+", addresses = "+addresses+", comment = "+comment+"]";
    }

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
			
			