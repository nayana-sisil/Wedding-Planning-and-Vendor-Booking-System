package com.webapp.demo.Service;

import com.webapp.demo.Model.Booking;
import com.webapp.demo.Repository.BookingRepository;
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
        Booking savedBooking = bookingRepository.saveBooking(booking);
        return Optional.ofNullable(savedBooking);
    }

    @Override
    public Optional<Booking> updateBooking(int id, Booking booking) {
        Booking updatedBooking = bookingRepository.updateBooking(id, booking);
        return Optional.ofNullable(updatedBooking);
    }

    @Override
    public boolean deleteBooking(int id) {
        return bookingRepository.deleteBooking(id);
    }

    @Override
    public Optional<Booking> findBookingById(int id) {
        Booking booking = bookingRepository.findBookingById(id);
        return Optional.ofNullable(booking);
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