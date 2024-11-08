package com.example.HotelBooking.HotelController;

import com.example.HotelBooking.HotelModels.HotelAdminDataModel;
import com.example.HotelBooking.HotelService.HotelAdminRegisterService;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.util.ResponseHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotelAdmin")
@CrossOrigin
public class HotelAdminRegister {

    @Autowired
    HotelAdminRegisterService hotelAdminRegisterService;

    @PostMapping("/register")
    public ResponseEntity<?> hotelAdminRegister(@RequestBody HotelAdminDataModel hotelAdminDataModel){
        try{
            hotelAdminRegisterService.registerHotelAdmin(hotelAdminDataModel);
            return ResponseHandle.registrationResponse(HttpStatus.OK, "success",null);
        }catch (HotelBookingException h){
            return ResponseHandle.registrationResponse(HttpStatus.BAD_REQUEST, "Failed",h.getError());
        }
    }
}
