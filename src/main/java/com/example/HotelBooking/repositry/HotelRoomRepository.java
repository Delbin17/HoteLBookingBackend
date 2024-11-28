package com.example.HotelBooking.repositry;


import com.example.HotelBooking.hotelroomentity.HotelRoomDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoomDetails,Long> {

    boolean existsByRoomId(Long roomId);



    boolean existsByRoomNumber(String roomNumber);


@Query("SELECT r FROM HotelRoomDetails r WHERE r.hotelAdminData.id = :id")
List<HotelRoomDetails> findByHotelAdminId(@Param("id") Long id);

    boolean existsByRoomNumberAndHotelAdminData_Id(String roomNumber, Long hotelAdminId);


}
