package com.vendor.vendormanagement.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.vendor.vendormanagement.model.Booking;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookingRepositoryImpl implements BookingRepository {
    private static final String FILE_PATH = "bookings.txt";
    private final ObjectMapper objectMapper;

    public BookingRepositoryImpl() {
        this.objectMapper = configureObjectMapper();
    }

    private ObjectMapper configureObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }

    @Override
    public List<Booking> getAllBookings() {
        File file = new File(FILE_PATH);
        List<Booking> bookings = new ArrayList<>();
        try {
            if (file.exists() && file.length() > 0) {
                bookings = objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Booking.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        List<Booking> bookings = getAllBookings();
        int maxId = bookings.stream().mapToInt(Booking::getId).max().orElse(0);
        booking.setId(maxId + 1);
        bookings.add(booking);
        try {
            objectMapper.writeValue(new File(FILE_PATH), bookings);
            return booking;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Booking updateBooking(int id, Booking booking) {
        List<Booking> bookings = getAllBookings();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getId() == id) {
                booking.setId(id);
                bookings.set(i, booking);
                try {
                    objectMapper.writeValue(new File(FILE_PATH), bookings);
                    return booking;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteBooking(int id) {
        List<Booking> bookings = getAllBookings();
        Booking toRemove = bookings.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        if (toRemove != null) {
            bookings.remove(toRemove);
            try {
                objectMapper.writeValue(new File(FILE_PATH), bookings);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Booking findBookingById(int id) {
        return getAllBookings().stream()
                .filter(booking -> booking.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Booking> findBookingsByWeddingId(int weddingId) {
        return getAllBookings().stream()
                .filter(booking -> booking.getWeddingId() == weddingId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> findBookingsByVendorId(int vendorId) {
        return getAllBookings().stream()
                .filter(booking -> booking.getVendorId() == vendorId)
                .collect(Collectors.toList());
    }
}
