package com.webapp.demo.Repository;

import com.webapp.demo.Model.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository {
    List<Booking> getAllBookings();
    Booking saveBooking(Booking booking);
    Booking updateBooking(int id, Booking booking);
    boolean deleteBooking(int id);
    Booking findBookingById(int id);
    List<Booking> findBookingsByWeddingId(int weddingId);
    List<Booking> findBookingsByVendorId(int vendorId);
}