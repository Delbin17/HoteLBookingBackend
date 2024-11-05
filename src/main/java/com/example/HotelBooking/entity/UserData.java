package com.example.HotelBooking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_data")
public class UserData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private  String firstName;

    @Column(name = "lastName")
    private  String lastName;

    @Column(name = "email")
    private  String email;

    @Column(name = "address")
    private  String address;

    @Column(name = "aadharNumber")
    private String aadharNumber;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private  String password;


    public UserData(String firstName, String lastName, String email, String address, String aadharNumber, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.aadharNumber = aadharNumber;
        this.phone = phone;
        this.password = password;
    }

    public UserData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
