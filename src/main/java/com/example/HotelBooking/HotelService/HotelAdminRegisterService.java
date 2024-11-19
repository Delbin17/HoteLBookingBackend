package com.example.HotelBooking.HotelService;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.repositry.HotelAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;


@Service
public class HotelAdminRegisterService {

    @Autowired
    private HotelAdminRepository hotelAdminRepository;

    public void registerHotelAdmin(MultipartFile file,String organiserName, String email,String phone,String registerId,String address,String password) throws HotelBookingException, IOException {
        String currentPath = Paths.get("").toAbsolutePath().toString();

        ArrayList<String> error=new ArrayList<>();
        error.add("this account is already registered");


        File folder = new File(currentPath + "/profile_images");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        HotelAdminData hotel=new HotelAdminData();
        if(hotelAdminRepository.existsByemail( hotel.getEmail())){

            throw  new HotelBookingException(error,"in valid");
        }

        String fileName = file.getOriginalFilename(); // Get the original file name
        Path destination = Paths.get(currentPath + "/profile_images", fileName); // Define the destination path
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING); // Save the file



        HotelAdminData hotelAdminData=new HotelAdminData();

        hotelAdminData.setProfile("images/" + fileName);

        hotelAdminData.setOrganiserName(organiserName);
        hotelAdminData.setEmail(email);
        hotelAdminData.setPhone(phone);
        hotelAdminData.setRegisterId(registerId);
        hotelAdminData.setAddress(address);
        hotelAdminData.setPassword(password);

        hotelAdminRepository.save(hotelAdminData);
    }

}