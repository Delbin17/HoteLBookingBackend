package com.example.HotelBooking.controller;

import com.example.HotelBooking.entity.UserData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.model.UserLoginDataModel;
import com.example.HotelBooking.service.UserLoginService;
import com.example.HotelBooking.util.ResponseHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userLogin")
@CrossOrigin
public class UserLoginController {

    @Autowired
    UserLoginService userLoginService;

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserLoginDataModel loginDataModel){
        try{
            UserData user = userLoginService.userLogin(loginDataModel);

            List<String> id=new ArrayList<>();

            id.add(user.getId().toString());
            id.add(user.getEmail());
            return ResponseHandle.registrationResponse(HttpStatus.OK, "success",id);
        }catch (HotelBookingException h){
            return ResponseHandle.registrationResponse(HttpStatus.BAD_REQUEST, "failed", h.getError());
        }
    }
}
