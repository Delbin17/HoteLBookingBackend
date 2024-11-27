package com.example.HotelBooking.hotelroomcontroller;


import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.hotelroomentity.HotelRoomDetails;
import com.example.HotelBooking.hotelroomservice.HotelRoomService;
import com.example.HotelBooking.repositry.HotelAdminRepository;
import com.example.HotelBooking.util.ResponseHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rooms")
@CrossOrigin
public class HotelRoomController {

    @Autowired
    private HotelRoomService roomService;

    @Autowired
    HotelAdminRepository hotelAdminRepository;

    @PostMapping("/add/{adminId}")
    public  ResponseEntity<Object> addRoom(
            @PathVariable("adminId") Long adminId,
            @RequestParam("roomNumber") String roomNumber,
            @RequestParam("floor") String floor,
            @RequestParam("roomStatus") String roomStatus,
            @RequestParam("type") String type,
            @RequestParam("guestLimit") Integer guestLimit,
            @RequestParam("description") String description,
            @RequestParam("facilities") String facilities,
            @RequestParam("images") List<MultipartFile> images)  throws IOException {


        ArrayList<String>error=new ArrayList<>();
        error.add("id null");
        if (adminId == null || adminId <= 0) { // Validate adminId
            System.out.println(adminId);
            return ResponseHandle.registrationResponse(HttpStatus.BAD_REQUEST, "Invalid admin ID", null);
        }


        HotelRoomDetails room = new HotelRoomDetails();

         HotelAdminData data = hotelAdminRepository.findById(adminId)
                .orElseThrow(() -> new HotelBookingException(error,"Admin not found for ID: "));

        room.setRoomNumber(roomNumber);
        room.setFloor(floor);
        room.setRoomStatus(roomStatus);
        room.setType(type);
        room.setGuestLimit(guestLimit);
        room.setDescription(description);
        room.setFacilities(facilities);
        room.setHotelAdminData(data);

        List<String> imagePaths = roomService.storeImages(images);
        room.setImages(imagePaths);
        try {
            roomService.addRoom(room);
            return ResponseHandle.registrationResponse(HttpStatus.OK, "room is registered", null);
        } catch (HotelBookingException e) {
            return  ResponseHandle.registrationResponse(HttpStatus.BAD_REQUEST," already register in this room id",e.getError());

        }
    }

    @GetMapping("/all")
   public List<HotelRoomDetails> getAllRooms() {
       return roomService.getAllRooms();
  }

    @GetMapping("/{roomId}")
    public Optional<HotelRoomDetails> getRoomById(@PathVariable Long roomId) {
        return roomService.getRoomById(roomId);
    }

    @PutMapping("/update/{roomId}")
    public HotelRoomDetails updateRoom(@PathVariable Long roomId,  @RequestParam("roomNumber") String roomNumber,
                                       @RequestParam("floor") String floor,
                                       @RequestParam("roomStatus") String roomStatus,
                                       @RequestParam("type") String type,
                                       @RequestParam("guestLimit") Integer guestLimit,
                                       @RequestParam("description") String description,
                                       @RequestParam("facilities") String facilities,
                                       @RequestParam("images") List<MultipartFile> images) throws HotelBookingException, IOException {
        HotelRoomDetails room = new HotelRoomDetails();
        room.setRoomNumber(roomNumber);
        room.setFloor(floor);
        room.setRoomStatus(roomStatus);
        room.setType(type);
        room.setGuestLimit(guestLimit);
        room.setDescription(description);
        room.setFacilities(facilities);

        List<String> imagePaths = roomService.storeImages(images);
        room.setImages(imagePaths);

        return roomService.updateRoom(roomId,room );
    }

    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long roomId) {
        try {
            roomService.deleteRoom(roomId);
            return ResponseHandle.registrationResponse(HttpStatus.OK, "Room id deleted", null);

        } catch (HotelBookingException e) {
            return ResponseHandle.registrationResponse(HttpStatus.BAD_REQUEST, "Room is not available", e.getError());
        }
    }
    }