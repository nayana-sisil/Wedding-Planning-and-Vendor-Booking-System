package com.webapp.demo.Service;

import com.webapp.demo.Model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookingService {
    List<Booking> getAllBookings();
    Optional<Booking> saveBooking(Booking booking);
    Optional<Booking> updateBooking(int id, Booking booking);
    boolean deleteBooking(int id);
    Optional<Booking> findBookingById(int id);
    List<Booking> findBookingsByWeddingId(int weddingId);
    List<Booking> findBookingsByVendorId(int vendorId);
}