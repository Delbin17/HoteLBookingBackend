package com.example.HotelBooking.HotelService;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.HotelModels.HotelAdminDataModel;
import com.example.HotelBooking.repositry.HotelAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelAdminRegisterService {

    @Autowired
    HotelAdminRepository hotelAdminRepository;
    public void registerHotelAdmin(HotelAdminDataModel hotelAdminDataModel) {
        HotelAdminData hotelAdminData=new HotelAdminData();
        hotelAdminData.setOrganiserName(hotelAdminDataModel.getOrganiserName());
        hotelAdminData.setEmail(hotelAdminDataModel.getEmail());
        hotelAdminData.setPhone(hotelAdminDataModel.getPhone());
        hotelAdminData.setRegisterId(hotelAdminDataModel.getRegisterId());
        hotelAdminData.setAddress(hotelAdminDataModel.getAddress());
        hotelAdminData.setPassword(hotelAdminDataModel.getPassword());

        hotelAdminRepository.save(hotelAdminData);
    }
}
