package com.example.HotelBooking.controller;

import com.example.HotelBooking.entity.HotelData;
//import com.example.testmail.service.EmailService;
import com.example.HotelBooking.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.HotelBooking.service.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class ForgotPasswordController {

    @Autowired
    private com.example.HotelBooking.service.EmailService emailService;
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody UserData data) {
        String otp = emailService.generateOtp(data.getEmail());
        try {
            emailService.sendOtpEmail(data.getEmail(), otp);
            return ResponseEntity.ok("OTP sent to email successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email: " + e.getMessage());
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        return ResponseEntity.ok("Password reset successful.");
    }
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody HotelData data) {
        if (emailService.verifyOtp(data.getEmail(), data.getOtp())) {
            String token = UUID.randomUUID().toString();
            return ResponseEntity.ok("OTP verified. Reset link sent to email.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP.");
        }
    }


}