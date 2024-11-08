package com.example.HotelBooking.controller;

import com.example.HotelBooking.entity.UserData;
import com.example.HotelBooking.model.OtpRequest;
import com.example.HotelBooking.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ForgotPasswordController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody OtpRequest otpRequest) {
        String email = otpRequest.getEmail();
        String otp = otpRequest.getOtp();

        if (otp == null || otp.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("OTP is required.");
        }

        boolean isValid = emailService.verifyOtp(email, otp);

        if (isValid) {
            return ResponseEntity.ok("OTP verified successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired OTP.");
        }
    }

    @PostMapping("/generate-otp")
    public ResponseEntity<String> generateOtp(@RequestBody UserData data) {
        if (data.getEmail() == null || data.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is required.");
        }

        String otp = emailService.generateOtp(data.getEmail());
        emailService.sendOtpEmail(data.getEmail(), otp);

        return ResponseEntity.ok("OTP sent to email: " + data.getEmail());
    }
}