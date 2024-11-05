package com.example.HotelBooking.service;

import com.example.HotelBooking.entity.UserData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.model.UserLoginDataModel;
import com.example.HotelBooking.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserLoginService {
    @Autowired
    UserRepositry userRepositry;
    public UserData userLogin(UserLoginDataModel loginDataModel) {

        ArrayList<String>error=new ArrayList<>();
        UserData userData= userRepositry.checkValidLogin(loginDataModel.getEmail(),loginDataModel.getPassword());


        error.add("invalid mail or password");

        if(userData == null ){
            throw new HotelBookingException(error,"invalid mail or password");
        }
        return userData;
    }

}
