package com.example.HotelBooking.HotelService;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.repositry.HotelAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HotelAdminProfileViewService {

    @Autowired
    private HotelAdminRepository hotelAdminRepository;

    public HotelAdminData profileViewById(Long id) throws HotelBookingException {
        ArrayList<String>error=new ArrayList<>();
        error.add(id.toString());
        return hotelAdminRepository.findById(id)
                .orElseThrow(() -> new HotelBookingException(error,":id HotelAdminData not found" ));
    }
}
