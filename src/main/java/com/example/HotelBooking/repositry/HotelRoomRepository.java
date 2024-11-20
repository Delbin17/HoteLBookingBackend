package com.example.HotelBooking.repositry;


import com.example.HotelBooking.hotelroomentity.HotelRoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoomDetails,Long> {

    boolean existsByRoomId(Long roomId);
}
