package com.example.HotelBooking.hotelroomentity;

import jakarta.persistence.*;

public class HotelRoomImages {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(name = "image_path")
    private String imagePath;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private HotelRoomDetails roomDetails;

    public HotelRoomImages() {
    }

    public HotelRoomImages(Long imageId, String imagePath, HotelRoomDetails roomDetails) {
        this.imageId = imageId;
        this.imagePath = imagePath;
        this.roomDetails = roomDetails;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePAth) {
        this.imagePath = imagePAth;
    }

    public HotelRoomDetails getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(HotelRoomDetails roomDetails) {
        this.roomDetails = roomDetails;
    }


}
