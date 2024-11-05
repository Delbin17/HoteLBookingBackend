package com.example.HotelBooking.repositry;


import com.example.HotelBooking.entity.UserData;
import com.example.HotelBooking.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry  extends JpaRepository<UserData ,Integer> {





}
