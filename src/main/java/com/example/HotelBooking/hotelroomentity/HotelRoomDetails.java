package com.example.HotelBooking.hotelroomentity;


import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

@Entity
@Table(name="room_details")
public class HotelRoomDetails {


       @Id

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String roomNumber;
        private String floor;
        private String roomStatus;
        private String roomType; // e.g., Double, Single, etc.
        private int totalGuestLimit;
        private String roomDescription;

        private List<String> facilities;

    public HotelRoomDetails() {
    }


    public HotelRoomDetails(Long id, String roomNumber, String floor, String roomStatus, String roomType, int totalGuestLimit, String roomDescription, List<String> facilities) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.roomStatus = roomStatus;
        this.roomType = roomType;
        this.totalGuestLimit = totalGuestLimit;
        this.roomDescription = roomDescription;
        this.facilities = facilities;
    }

      public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(String roomStatus) {
            this.roomStatus = roomStatus;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public int getTotalGuestLimit() {
            return totalGuestLimit;
        }

        public void setTotalGuestLimit(int totalGuestLimit) {
            this.totalGuestLimit = totalGuestLimit;
        }

        public String getRoomDescription() {
            return roomDescription;
        }

        public void setRoomDescription(String roomDescription) {
            this.roomDescription = roomDescription;
        }

      public List<String> getFacilities() {
     return facilities;
  }

        public void setFacilities(List<String> facilitiesList) {
            this.facilities = Collections.singletonList(String.join(", ", facilitiesList));
      }




    }







