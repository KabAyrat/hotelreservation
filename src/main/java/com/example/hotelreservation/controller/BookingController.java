

package com.example.hotelreservation.controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.hotelreservation.models.Booking;
import com.example.hotelreservation.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }
}

