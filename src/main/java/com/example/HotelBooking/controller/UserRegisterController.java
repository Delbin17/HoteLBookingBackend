package com.example.HotelBooking.controller;


import com.example.HotelBooking.entity.UserData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.model.DataModel;
import com.example.HotelBooking.service.UserRegisterService;
import com.example.HotelBooking.util.ResponseHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userRegister")
@CrossOrigin
public class UserRegisterController {

    @Autowired
    UserRegisterService service;


    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody DataModel user){
        try {


            service.RegisterUser(user);
            return ResponseHandle.registrationResponse(HttpStatus.OK, "success",null);

        }catch(HotelBookingException h){
            return ResponseHandle.registrationResponse(HttpStatus.BAD_REQUEST, "failed",h.getError());

        }


    }




}
