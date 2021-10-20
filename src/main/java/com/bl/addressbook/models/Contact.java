package com.bl.addressbook.models;

public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String mobileNo;
    private String  emailId;


    public Contact(String firstName, String lastName, String address, String city, String state, String zipCode, String  mobileNo, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.mobileNo = mobileNo;
        this.emailId=emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
    public String  getMobileNo() {
        return mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setlName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void setMobileNo(String  mobileNo) {
        this.mobileNo = mobileNo;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }



    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                ", mobileNo=" + mobileNo +
                ",emailId="  +emailId+
                '}';
    }
}
