package com.example.HotelBooking.service;


import com.example.HotelBooking.entity.UserData;
import com.example.HotelBooking.repositry.UserRepositry;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {

    @Autowired
    UserRepositry repo;

    public void RegisterUser(UserData user){
        repo.save(user);

    }
}
