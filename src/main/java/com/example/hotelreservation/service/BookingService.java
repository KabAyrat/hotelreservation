package com.example.hotelreservation.service;

import com.example.hotelreservation.models.Booking;
import com.example.hotelreservation.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Получить бронирования по userId
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    // Сохранить бронирование (добавляем этот метод!)
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}
