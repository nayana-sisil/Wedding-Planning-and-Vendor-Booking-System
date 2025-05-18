package com.webapp.demo.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.webapp.demo.Model.Booking;
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
        
        // Ensure the ID is unique
        int maxId = 0;
        for (Booking existingBooking : bookings) {
            if (existingBooking.getId() > maxId) {
                maxId = existingBooking.getId();
            }
        }
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
            Booking existingBooking = bookings.get(i);
            if (existingBooking.getId() == id) {
                booking.setId(id); // Ensure ID remains the same
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
        Booking toRemove = null;

        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                toRemove = booking;
                break;
            }
        }

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
        List<Booking> bookings = getAllBookings();
        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public List<Booking> findBookingsByWeddingId(int weddingId) {
        List<Booking> bookings = getAllBookings();
        return bookings.stream()
                .filter(booking -> booking.getWeddingId() == weddingId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> findBookingsByVendorId(int vendorId) {
        List<Booking> bookings = getAllBookings();
        return bookings.stream()
                .filter(booking -> booking.getVendorId() == vendorId)
                .collect(Collectors.toList());
    }

    private ObjectMapper configureObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }
}