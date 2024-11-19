package com.example.HotelBooking.HotelController;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.HotelService.HotelAdminProfileViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hoteladmin")
@CrossOrigin
public class HotelAdminProfileViewController {

    @Autowired
    HotelAdminProfileViewService hotelAdminProfileViewService;

    @GetMapping("/viewbyid/{id}")
    public HotelAdminData hotelAdminProfileView(@PathVariable("id") Long id){
        return hotelAdminProfileViewService.profileViewById(id);
    }
}
