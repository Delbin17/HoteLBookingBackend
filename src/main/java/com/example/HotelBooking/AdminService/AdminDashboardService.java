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

    public List<HotelAdminData> readAdminAllData()
    {
       List<HotelAdminData> hotelAdminData = hotelAdminRepository.findAll();

        for (int i = 0; i < hotelAdminData.size(); i++) {
            for (int j = 0; j <  hotelAdminData.size()-i-1; j++) {
                if(hotelAdminData.get(j).getId().compareTo(hotelAdminData.get(j+1).getId())<0){
                    HotelAdminData temp = hotelAdminData.get(j);
                    hotelAdminData.set(j,hotelAdminData.get(j+1));
                    hotelAdminData.set(j+1,temp);
                }

            }
        }

        return hotelAdminData;
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
