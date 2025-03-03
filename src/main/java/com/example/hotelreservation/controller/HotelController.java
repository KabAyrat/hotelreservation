package com.example.hotelreservation.controller;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels") // Уникальный путь для MVC
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // Получение списка отелей по ID города (для отображения HTML)
    @GetMapping("/city/{cityId}")
    public String getHotelsByCity(@PathVariable Long cityId, Model model) {
        List<Hotel> hotels = hotelService.getHotelsByCity(cityId);
        model.addAttribute("hotels", hotels);
        return "hotel-list"; // Thymeleaf шаблон
    }

    // Получение информации об отеле по ID
    @GetMapping("/{hotelId}")
    public String getHotelById(@PathVariable Long hotelId, Model model) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        model.addAttribute("hotel", hotel);
        return "hotel-details"; // Thymeleaf шаблон
    }
}
