package com.example.HotelBooking.repositry;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelAdminRepository extends JpaRepository<HotelAdminData,Long> {

    @Query("SELECT c FROM HotelAdminData c WHERE c.email = :email AND c.password = :password")
    HotelAdminData loginAdminHotel(@Param("email") String email,@Param("password") String password);

    Boolean existsByemail(String email);
}
