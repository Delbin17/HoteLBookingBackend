package com.example.HotelBooking.exception;

import java.util.List;

public class HotelBookingException extends  RuntimeException{
    List<String>error;
    String message;

    public HotelBookingException(List<String> error, String message) {
        this.error = error;
        this.message = message;
    }




    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
