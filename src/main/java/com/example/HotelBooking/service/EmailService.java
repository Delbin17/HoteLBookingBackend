package com.example.HotelBooking.service;

import com.example.HotelBooking.entity.UserData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class EmailService {

    private static final long OTP_EXPIRY_TIME = 5 * 60 * 1000;
    private final Map<String, String> otpStore = new HashMap<>();
    private final Map<String, Long> otpTimestampStore = new HashMap<>();

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepositry userRepositry;
    public String generateOtp(String email) {
        Optional<UserData> user = userRepositry.findByEmail(email);
        if (user.isEmpty()) {
            throw new HotelBookingException("Email not found.");
        }

        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        String otpString = String.valueOf(otp);

        long currentTime = System.currentTimeMillis();

        otpStore.put(email, otpString);
        otpTimestampStore.put(email, currentTime);

        return otpString;
    }

    public boolean verifyOtp(String email, String otp) {
        String storedOtp = otpStore.get(email);
        Long timestamp = otpTimestampStore.get(email);

        if (storedOtp == null || timestamp == null) {
            return false;
        }

        long currentTime = System.currentTimeMillis();

        if (currentTime - timestamp > OTP_EXPIRY_TIME) {
            otpStore.remove(email);
            otpTimestampStore.remove(email);
            return false;
        }

        boolean isValid = otp.equals(storedOtp);

        if (isValid) {
            otpStore.remove(email);
            otpTimestampStore.remove(email);
        }

        return isValid;
    }

    public void sendOtpEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP for Hotel Booking");
        message.setText("Your OTP is: " + otp );

        mailSender.send(message);
    }


}