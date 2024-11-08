package com.example.HotelBooking.service;
import com.example.HotelBooking.entity.HotelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private final Map<String, HotelData> otpStore = new HashMap<>();

    private static final long OTP_EXPIRY_TIME = 5 * 60 * 1000;

    public void sendOtpEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP for Password Reset");
        message.setText("Your OTP is: " + otp);
        mailSender.send(message);
    }

    public String generateOtp(String email) {
        Random random = new Random();
        int otp = 100 + random.nextInt(900);
        String otpString = String.valueOf(otp);

        HotelData otpDetails = new HotelData();
        otpStore.put(email, otpDetails);

        return otpString;
    }

    public boolean verifyOtp(String email, String otp) {
        HotelData otpDetails = otpStore.get(email);

        if (otpDetails == null) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime - otpDetails.getTimestamp() > OTP_EXPIRY_TIME) {
            otpStore.remove(email);
            return false;
        }

        return otp.equals(otpDetails.getOtp());
    }
}