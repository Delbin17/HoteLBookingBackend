package com.example.HotelBooking.HotelController;

import com.example.HotelBooking.HotelService.HotelAdminRegisterService;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.util.ResponseHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/hotelAdmin")
@CrossOrigin
public class HotelAdminRegister {

    @Autowired
    HotelAdminRegisterService hotelAdminRegisterService;

    @PostMapping("/register")
    public ResponseEntity<?> hotelAdminRegister(
            @RequestParam("profile") MultipartFile file,
            @RequestParam("organiserName") String organiserName,
            @RequestParam("email") String email,
            @RequestParam("phone")String phone,
            @RequestParam("registerId") String registerId,
            @RequestParam("address") String address,
            @RequestParam("password") String password ){

      try{

          hotelAdminRegisterService.registerHotelAdmin(file, organiserName, email, phone, registerId, address, password);


          return ResponseHandle.registrationResponse(HttpStatus.OK, "Success", null);

        } catch (HotelBookingException h) {
          return ResponseHandle.registrationResponse(HttpStatus.BAD_REQUEST, "Failed", h.getError());

      } catch (IOException e) {

          throw new RuntimeException(e);
      }


    }
    }