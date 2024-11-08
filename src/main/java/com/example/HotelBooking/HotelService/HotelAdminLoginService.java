package com.example.HotelBooking.HotelService;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.HotelModels.HotelAdminLoginModel;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.repositry.HotelAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HotelAdminLoginService {

    @Autowired
    HotelAdminRepository hotelAdminRepository;

    public HotelAdminData loginHotelAdmin(HotelAdminLoginModel hotelAdminLoginModel)  throws HotelBookingException {

        ArrayList<String>error=new ArrayList<>();
        error.add("invalid username or Password");
        HotelAdminData hotelAdminData=hotelAdminRepository.loginAdminHotel(hotelAdminLoginModel.getEmail(),hotelAdminLoginModel.getPassword());

        if(hotelAdminData == null){
            throw new HotelBookingException(error,"");
        }
        return hotelAdminData;
    }
}
