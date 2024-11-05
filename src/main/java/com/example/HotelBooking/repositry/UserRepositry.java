package com.example.HotelBooking.repositry;

import com.example.HotelBooking.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositry extends JpaRepository<UserData,Long> {

    @Query("SELECT c FROM UserData c WHERE c.email = :email AND c.password = :password ")
    UserData checkValidLogin(@Param("email") String gmail, @Param("password") String password);

}
