package com.example.hotelreservation.controller;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels") // 🌍 Базовый путь для контроллера
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // 🔍 Получение списка отелей по ID города (отображение HTML)
    @GetMapping("/city/{cityId}")
    @ResponseBody // ✅ Возвращаем JSON
    public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable Long cityId) {
        List<Hotel> hotels = hotelService.getHotelsByCity(cityId);
        return ResponseEntity.ok(hotels);
    }

    // 🏨 Получение информации об отеле по ID (для страницы отеля)
    @GetMapping("/{hotelId}")
    public String getHotelById(@PathVariable Long hotelId, Model model) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        model.addAttribute("hotel", hotel);
        return "hotel"; // ⚡ Thymeleaf шаблон hotel.html
    }
}
