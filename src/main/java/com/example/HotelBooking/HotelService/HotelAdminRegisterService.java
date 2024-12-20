package com.example.HotelBooking.HotelService;

import com.example.HotelBooking.HotelEntity.HotelAdminData;
import com.example.HotelBooking.exception.HotelBookingException;
import com.example.HotelBooking.repositry.HotelAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelAdminRegisterService {

    @Autowired
    private HotelAdminRepository hotelAdminRepository;

    public void registerHotelAdmin(MultipartFile file, String organiserName, String email, String phone, String registerId, String address, String password) throws HotelBookingException, IOException {

        System.out.println("Organiser Name: " + organiserName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Password: " + password);

        String resourcesPath = "src/main/resources/static/images"; // Resources directory path
        ArrayList<String> error = new ArrayList<>();
        error.add("This account is already registered");

        // Check if the email is already in use
        if (hotelAdminRepository.existsByEmail(email)) {
            throw new HotelBookingException(error, "Invalid: Email already exists in the system.");
        }

        File folder = new File(resourcesPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        if (file == null || file.isEmpty()) {
            throw new HotelBookingException(new ArrayList<>(List.of("Invalid file")), "File is empty or missing");
        }

        // Sanitize the filename by replacing spaces with underscores
        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null) {
            throw new HotelBookingException(new ArrayList<>(List.of("Invalid file name")), "File name is missing");
        }

        String sanitizedFileName = originalFileName.replaceAll("\\s+", "_"); // Replace spaces with underscores
        Path destination = Paths.get(resourcesPath, sanitizedFileName);
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

        HotelAdminData hotelAdminData = new HotelAdminData();
        hotelAdminData.setProfile("/images/" + sanitizedFileName); // Update the path to be relative to static
        hotelAdminData.setOrganiserName(organiserName);
        hotelAdminData.setEmail(email);
        hotelAdminData.setPhone(phone);
        hotelAdminData.setRegisterId(registerId);
        hotelAdminData.setAddress(address);
        hotelAdminData.setPassword(password);
        hotelAdminData.setLocalDate(LocalDate.now());

        hotelAdminRepository.save(hotelAdminData);
    }

}