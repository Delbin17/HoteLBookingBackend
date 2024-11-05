package com.example.HotelBooking.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandle {
    public static ResponseEntity<Object> registrationResponse(HttpStatus httpStatus, String message, List<String> error) {
        Map<String, Object> response = new HashMap<>();
        response.put("Status", httpStatus.value());
        response.put("message", message);
        response.put("error", error);

        return new ResponseEntity<>(response, httpStatus);
    }
}
