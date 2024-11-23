package com.example.HotelBooking.hotelroomentity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Table(name = "Hotel_rooms")
public class HotelRoomDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(name = "roomNumber", nullable = false)
    @NotEmpty
    private String roomNumber;


    @Column(name = "floor", nullable = false)
    @NotEmpty
    @Size( min = 1, message = "floor cannot be empty")
    private String floor;


    @Column(name = "roomStatus", nullable = false)
    @NotEmpty
    @Size( min = 3, message = "should be atleat one word")



    private String roomStatus;


    @Column(name = "type", nullable = false)


    private String type;

    @Column(name = "guestLimit",nullable = false)
    private Integer guestLimit;

    @Column(name = "description", length = 200)
    private String description;


    @Column(name = "facilities", length = 1000)

    private String facilities;

    @ElementCollection
    @CollectionTable(name = "room_image", joinColumns = @JoinColumn(name = "room_id"))

    @Column(name = "image_path")
    private List<String> images;


    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getGuestLimit() {
        return guestLimit;
    }

    public void setGuestLimit(Integer guestLimit) {
        this.guestLimit = guestLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}