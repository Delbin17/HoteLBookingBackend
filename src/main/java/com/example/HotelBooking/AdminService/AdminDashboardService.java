package com.example.HotelBooking.AdminService;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.repositry.HotelAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDashboardService {

    @Autowired
    HotelAdminRepository hotelAdminRepository;

    public List<HotelAdminData> readAdminAllData() {
        return hotelAdminRepository.findAll();
    }

    public void deleteHotelAdminRequest(Long id) {
        hotelAdminRepository.deleteById(id);
    }

    public void approveRequest(Long id) throws HotelBookingException {

        ArrayList<String> error=new ArrayList<>();
        error.add(id+": not found");
        HotelAdminData hotelAdminData=hotelAdminRepository.findById(id).orElseThrow(()-> new HotelBookingException(error,"id not found"));

        hotelAdminData.setStatus(true);
        hotelAdminRepository.save(hotelAdminData);
    }

    public void declineRequest(Long id) throws HotelBookingException {

        ArrayList<String> error=new ArrayList<>();
        error.add(id+": not found");
        HotelAdminData hotelAdminData=hotelAdminRepository.findById(id).orElseThrow(()-> new HotelBookingException(error,"id not found"));

        hotelAdminData.setStatus(false);
        hotelAdminRepository.save(hotelAdminData);
    }
}
