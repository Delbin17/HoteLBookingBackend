package com.example.HotelBooking.hotelroomservice;


import com.example.HotelBooking.hotelroomentity.HotelRoomDetails;
import com.example.HotelBooking.hotelroomentity.HotelRoomImages;
import com.example.HotelBooking.repositry.HotelRoomImagesRepository;
import com.example.HotelBooking.repositry.HotelRoomRepository;
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
import java.util.List;

@Service
public class HotelroomService {

    @Autowired
    HotelRoomImagesRepository hotelRoomImagesRepository;

    @Autowired
    HotelRoomRepository hotelRoomRepository;


    public HotelRoomDetails addRoomWithImages(HotelRoomDetails roomDetails, List<MultipartFile> files) {
        List<HotelRoomImages> roomImagesList = new ArrayList<>();


        String currentPath = Paths.get("").toAbsolutePath().toString();
        File folder = new File(currentPath + "/images");
        if (!folder.exists()) {
            folder.mkdirs();


        }


        for (MultipartFile file : files) {
            try {
                // Get the file name and define the destination path
                String fileName = file.getOriginalFilename();
                Path destination = Paths.get(currentPath + "/images", fileName);

                // Copy the file to the server's folder
                Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

                // Create and add RoomImages object
                HotelRoomImages roomImage = new HotelRoomImages();
                roomImage.setImagePath("images/" + fileName);
                roomImage.setRoomDetails(roomDetails);
                roomImagesList.add(roomImage);

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to save image: " + file.getOriginalFilename(), e);
            }
        }

        HotelRoomDetails savedhotelRoomDetailss = hotelRoomRepository.save(roomDetails);


        hotelRoomImagesRepository.saveAll(roomImagesList);

        return savedhotelRoomDetailss;
    }
}
