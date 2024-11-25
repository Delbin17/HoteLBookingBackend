package com.example.HotelBooking.HotelEntity;

import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

import java.time.LocalDate;

@Entity
@Table(name = "hotel_admin_data")
public class HotelAdminData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "organiser_name")
    private String organiserName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "register_id")
    private String registerId;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private  String password;

    @Column(name = "status")
    private Boolean status;

    @Column(name="profile")
    private String profile;

    @Column(name = "date")
    private LocalDate localDate;



    public HotelAdminData(String organiserName, String email, String phone, String registerId, String address, String password, Boolean status, String profile, LocalDate localDate) {
        this.organiserName = organiserName;
        this.email = email;
        this.phone = phone;
        this.registerId = registerId;
        this.address = address;
        this.password = password;
        this.status = status;
        this.profile = profile;
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public HotelAdminData() {

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRegisterId() { return registerId;
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

    public String getProfile() { return profile;}

    public void setProfile(String filePath) {this.profile = filePath;}
}
