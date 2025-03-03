package com.example.hotelreservation.controller;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Уникальный путь для REST-API
public class HotelRestController {

    private final HotelService hotelService;

    public HotelRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // Изменён путь для REST-метода
    @GetMapping("/hotels/city/{cityId}") // уникальный путь
    public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable Long cityId) {
        List<Hotel> hotels = hotelService.getHotelsByCity(cityId);
        return ResponseEntity.ok(hotels);
    }

    // Метод для получения информации об отеле
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }
}
