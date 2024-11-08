package com.example.HotelBooking.HotelModels;

public class HotelAdminLoginModel {

    private String email;
    private  String password;

    public HotelAdminLoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public HotelAdminLoginModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
