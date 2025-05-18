package com.vendor.vendormanagement.service;


import com.vendor.vendormanagement.model.Booking;
import com.vendor.vendormanagement.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.getAllBookings();
    }

    @Override
    public Optional<Booking> saveBooking(Booking booking) {
        return Optional.ofNullable(bookingRepository.saveBooking(booking));
    }

    @Override
    public Optional<Booking> updateBooking(int id, Booking booking) {
        return Optional.ofNullable(bookingRepository.updateBooking(id, booking));
    }

    @Override
    public boolean deleteBooking(int id) {
        return bookingRepository.deleteBooking(id);
    }

    @Override
    public Optional<Booking> findBookingById(int id) {
        return Optional.ofNullable(bookingRepository.findBookingById(id));
    }

    @Override
    public List<Booking> findBookingsByWeddingId(int weddingId) {
        return bookingRepository.findBookingsByWeddingId(weddingId);
    }

    @Override
    public List<Booking> findBookingsByVendorId(int vendorId) {
        return bookingRepository.findBookingsByVendorId(vendorId);
    }
}
