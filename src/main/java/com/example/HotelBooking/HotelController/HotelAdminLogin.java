package com.example.HotelBooking.HotelController;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.HotelModels.HotelAdminLoginModel;
import com.example.HotelBooking.HotelService.HotelAdminLoginService;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.util.ResponseHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hotelAdmin")
@CrossOrigin
public class HotelAdminLogin {

    @Autowired
    HotelAdminLoginService hotelAdminLoginService;

    @PostMapping("/login")
    public ResponseEntity<?>hotelAdminLogin(@RequestBody HotelAdminLoginModel hotelAdminLoginModel){

try{
       HotelAdminData hotelAdminData= hotelAdminLoginService.loginHotelAdmin(hotelAdminLoginModel);

    ArrayList<String> id = new ArrayList<>();
    id.add(hotelAdminData.getId().toString());
    return ResponseHandle.registrationResponse(HttpStatus.OK, "success",id);
}catch (HotelBookingException h){
    return ResponseHandle.registrationResponse(HttpStatus.BAD_REQUEST, "Failed",h.getError());
}
    }
}
