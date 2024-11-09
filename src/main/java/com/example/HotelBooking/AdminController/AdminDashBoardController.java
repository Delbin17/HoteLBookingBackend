package com.example.HotelBooking.AdminController;

import com.example.HotelBooking.AdminService.AdminDashboardService;
import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.util.ResponseHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminDashBoardController {

    @Autowired
    AdminDashboardService adminDashboardService;

    @GetMapping("/dashboard")
    public List<HotelAdminData> readAllAdminData(){

        return adminDashboardService.readAdminAllData();
    }

    //Decline
    @DeleteMapping("decline/{id}")
    public ResponseEntity<?>declineRequest(@PathVariable("id") Long id){
        try {
            adminDashboardService.declineHotelAdminRequest(id);
            return ResponseHandle.registrationResponse(HttpStatus.OK, "success",null);
        }catch (HotelBookingException h){
            return ResponseHandle.registrationResponse(HttpStatus.BAD_REQUEST, "failed",h.getError());
        }

    }
}
