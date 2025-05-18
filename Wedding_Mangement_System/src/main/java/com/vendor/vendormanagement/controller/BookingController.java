package com.vendor.vendormanagement.controller;


import com.vendor.vendormanagement.model.Booking;
import com.vendor.vendormanagement.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
        return bookingService.findBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Booking>> getByVendorId(@PathVariable int vendorId) {
        return ResponseEntity.ok(bookingService.findBookingsByVendorId(vendorId));
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking)
                .map(b -> new ResponseEntity<>(b, HttpStatus.CREATED))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        boolean deleted = bookingService.deleteBooking(id);
        return deleted ?
                ResponseEntity.ok("Booking deleted") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
    }
}
