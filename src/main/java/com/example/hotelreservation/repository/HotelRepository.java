package com.example.hotelreservation.repository;

import com.example.hotelreservation.models.Hotel;
import com.example.hotelreservation.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // 🔥 Исправленный метод поиска отелей по городу
    List<Hotel> findByCity(City city);
}
