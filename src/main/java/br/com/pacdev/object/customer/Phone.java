package br.com.pacdev.object.customer;

public class Phone
{
    private String areaCode;

    private String number;

    public String getAreaCode ()
    {
        return areaCode;
    }

    public void setAreaCode (String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [areaCode = "+areaCode+", number = "+number+"]";
    }
}