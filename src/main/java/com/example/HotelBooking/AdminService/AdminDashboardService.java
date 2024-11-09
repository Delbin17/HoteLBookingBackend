package com.example.HotelBooking.AdminService;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.repositry.HotelAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDashboardService {

    @Autowired
    HotelAdminRepository hotelAdminRepository;

    public List<HotelAdminData> readAdminAllData() {
        return hotelAdminRepository.findAll();
    }

    public void declineHotelAdminRequest(Long id) {
        hotelAdminRepository.deleteById(id);
    }
}
