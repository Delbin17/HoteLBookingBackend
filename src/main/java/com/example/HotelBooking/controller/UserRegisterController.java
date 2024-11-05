package com.example.HotelBooking.controller;


import com.example.HotelBooking.entity.UserData;
import com.example.HotelBooking.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserRegisterController {

    @Autowired
    UserRegisterService service;


    @PostMapping("register")
    public void RegisterUser(UserData user){
        service.RegisterUser(user);


    }




}
