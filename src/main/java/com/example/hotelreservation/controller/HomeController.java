package com.example.hotelreservation.controller;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final HotelService hotelService;

    public HomeController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // ✅ Главная страница
    @GetMapping
    public String homePage(Model model) {
        return "index"; // Thymeleaf-шаблон index.html
    }

    // ✅ Поиск отелей по ID города
    @PostMapping("/search")
    public String searchHotels(@RequestParam Long cityId, Model model) {
        List<Hotel> hotels = hotelService.getHotelsByCity(cityId);
        model.addAttribute("hotels", hotels);
        return "hotel-list"; // Отображаем список найденных отелей
    }
}
