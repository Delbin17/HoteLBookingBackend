package com.example.HotelBooking.hotelroomcontroller;

import com.example.HotelBooking.hotelroomentity.HotelRoomDetails;
import com.example.HotelBooking.hotelroomservice.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class HotelRoomController {

    @Autowired
    private HotelRoomService roomService;

    @PostMapping("/add")
    public HotelRoomDetails addRoom(@RequestBody HotelRoomDetails room) {
        return roomService.addRoom(room);
    }

//    @GetMapping("/all")
//    public List<HotelRoomDetails> getAllRooms() {
//        return roomService.getAllRooms();
//    }

//    @GetMapping("/{id}")
//    public Optional<HotelRoomDetails> getRoomById(@PathVariable Long id) {
//        return roomService.getRoomById(id);
//    }

    @PutMapping("/update/{roomId}")
    public HotelRoomDetails updateRoom(@PathVariable Long roomId, @RequestBody HotelRoomDetails roomDetails) {
        return roomService.updateRoom(roomId, roomDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
    }
}