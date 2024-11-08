package com.example.HotelBooking.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data

public class HotelData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String Otp;
     long timestamp;

    public HotelData() {
    }

    public HotelData(String email, String otp, long timestamp) {
        this.email = email;
        Otp = otp;
        this.timestamp = timestamp;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return Otp;
    }

    public void setOtp(String otp) {
        Otp = otp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


}
