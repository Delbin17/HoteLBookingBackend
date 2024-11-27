package com.example.HotelBooking.hotelroomentity;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
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
    @Size(min = 1, message = "floor cannot be empty")
    private String floor;


    @Column(name = "roomStatus", nullable = false)
    @NotEmpty
    @Size(min = 3, message = "should be atleat one word")


    private String roomStatus;


    @Column(name = "type", nullable = false)


    private String type;

    @Column(name = "guestLimit", nullable = false)
    private Integer guestLimit;

    @Column(name = "description", length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "hotel_admin_id",nullable = false)
    private HotelAdminData hotelAdminData;


    @Column(name = "facilities", length = 1000)
    private String facilities;

    @ElementCollection
    @CollectionTable(name = "room_image", joinColumns = @JoinColumn(name = "room_id"))

    @Column(name = "image_path")
    private List<String> images;

    public HotelRoomDetails(String roomNumber, String floor, String roomStatus, String type, Integer guestLimit, String description, HotelAdminData hotelAdminData, String facilities, List<String> images) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.roomStatus = roomStatus;
        this.type = type;
        this.guestLimit = guestLimit;
        this.description = description;
        this.hotelAdminData = hotelAdminData;
        this.facilities = facilities;
        this.images = images;
    }

    public HotelRoomDetails() {
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public @NotEmpty String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(@NotEmpty String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public @NotEmpty @Size(min = 1, message = "floor cannot be empty") String getFloor() {
        return floor;
    }

    public void setFloor(@NotEmpty @Size(min = 1, message = "floor cannot be empty") String floor) {
        this.floor = floor;
    }

    public @NotEmpty @Size(min = 3, message = "should be atleat one word") String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(@NotEmpty @Size(min = 3, message = "should be atleat one word") String roomStatus) {
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

    public HotelAdminData getHotelAdminData() {
        return hotelAdminData;
    }

    public void setHotelAdminData(HotelAdminData hotelAdminData) {
        this.hotelAdminData = hotelAdminData;
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