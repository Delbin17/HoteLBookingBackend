package com.example.HotelBooking.HotelModels;

public class HotelAdminDataModel {

    private String organiserName;
    private String email;
    private String phone;
    private String registerId;
    private String address;
    private String password;

    public HotelAdminDataModel(String organiserName, String email, String phone, String registerId, String address,String password) {
        this.organiserName = organiserName;
        this.email = email;
        this.phone = phone;
        this.registerId = registerId;
        this.address = address;
        this.password=password;
    }

    public HotelAdminDataModel() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganiserName() {
        return organiserName;
    }

    public void setOrganiserName(String organiserName) {
        this.organiserName = organiserName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
