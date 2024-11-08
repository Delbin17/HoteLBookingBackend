package com.example.HotelBooking.exception;

import java.util.List;

public class HotelBookingException extends  RuntimeException{
    List<String>error;
    String message;

    public HotelBookingException(String message) {
        this.error = error;
        this.message = message;
    }




    @Override
    public String getMessage() {
        return message;
    }

    public List<String> getError() {
        return error;
    }
}

