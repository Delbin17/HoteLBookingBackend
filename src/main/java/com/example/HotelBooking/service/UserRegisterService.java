package com.example.HotelBooking.service;


import com.example.HotelBooking.entity.UserData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.model.DataModel;
import com.example.HotelBooking.repositry.UserRepositry;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegisterService {

    @Autowired
    UserRepositry repo;

    public void RegisterUser(DataModel user){

        UserData userData=new UserData();

        userData.setAddress(user.getAddress());
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        userData.setAadharNumber(user.getAadharNumber());
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setPhone(user.getMobile());

        repo.save(userData);

    }

}
