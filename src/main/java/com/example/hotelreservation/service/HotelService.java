package com.example.hotelreservation.service;

import com.example.hotelreservation.models.City;
import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.repository.CityRepository;
import com.example.hotelreservation.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final CityRepository cityRepository;

    public HotelService(HotelRepository hotelRepository, CityRepository cityRepository) {
        this.hotelRepository = hotelRepository;
        this.cityRepository = cityRepository;
    }

    // ✅ Получение списка отелей по ID города
    public List<Hotel> getHotelsByCity(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("Город с ID " + cityId + " не найден"));
        return hotelRepository.findByCity(city);
    }

    // ✅ Получение отеля по ID
    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Отель с ID " + hotelId + " не найден"));
    }
}
