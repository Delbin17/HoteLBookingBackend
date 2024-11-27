package com.example.HotelBooking.hotelroomservice;

import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.hotelroomentity.HotelRoomDetails;
import com.example.HotelBooking.repositry.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelRoomService {

    @Autowired
    HotelRoomRepository roomRepository;


    private static final String IMAGE_DIRECTORY = "images/";

    public List<String> storeImages(List<MultipartFile> images) throws IOException {
        List<String> imagePaths = new ArrayList<>();
        for (MultipartFile image : images) {
            if (!image.isEmpty()) {
                String imagePath = IMAGE_DIRECTORY + image.getOriginalFilename();
                Path path = Paths.get(imagePath);
                Files.createDirectories(path.getParent());
                Files.write(path, image.getBytes());
                imagePaths.add(imagePath);
            }
        }
        return imagePaths;
    }

    public HotelRoomDetails addRoom(HotelRoomDetails room) {



        if (roomRepository.existsByRoomNumberAndHotelAdminData_Id(
                room.getRoomNumber(), room.getHotelAdminData().getId())) {

            throw new RuntimeException("Room number " + room.getRoomNumber() +
                    " already exists for the given hotel.");
        }
       return  roomRepository.save(room);

    }

    public List<HotelRoomDetails> getAllRooms() {


        return roomRepository.findAll();
    }

    public List<HotelRoomDetails> findRoomsByAdminId(Long id) {
        return roomRepository.findByHotelAdminId(id);
    }

    public HotelRoomDetails updateRoom(Long roomId, HotelRoomDetails roomDetails)  {


        HotelRoomDetails room = roomRepository.findById(roomId)


                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));

        room.setRoomNumber(roomDetails.getRoomNumber());

        room.setFloor(roomDetails.getFloor());

        room.setRoomStatus(roomDetails.getRoomStatus());

        room.setType(roomDetails.getType());

        room.setGuestLimit(roomDetails.getGuestLimit());

        room.setDescription(roomDetails.getDescription());

        room.setFacilities(roomDetails.getFacilities());

        room.getImages().clear();

        room.setImages(roomDetails.getImages());

        return roomRepository.save(room);
    }

    public void deleteRoom(Long roomId) {

        if (!roomRepository.existsById(roomId)) {
            List<String> errors = new ArrayList<>();
            errors.add("Invalid room number: " + roomId);
            throw new HotelBookingException(errors, "This room is not yet registered.");
        }



        roomRepository.deleteById(roomId);
    }


}


