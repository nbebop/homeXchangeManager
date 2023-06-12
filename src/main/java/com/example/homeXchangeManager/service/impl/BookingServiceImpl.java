package com.example.homeXchangeManager.service.impl;

import com.example.homeXchangeManager.models.Booking;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.BookingRepository;
import com.example.homeXchangeManager.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void delete(int id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> findByHost(User host) {
        return bookingRepository.findByHost(host);
    }

    @Override
    public List<Booking> findByGuest(User guest) {
        return bookingRepository.findByGuest(guest);
    }

    public Booking findById(int id) {
        return bookingRepository.findByBookingId(id);
    }

    @Override
    public List<Booking> findByHostAndBookingRequestDateBefore(User host, Date before) {
        return bookingRepository.findByHostAndBookingRequestDateBefore(host, before);
    }

    @Override
    public List<Booking> findByGuestAndBookingRequestDateBefore(User guest, Date before) {
        return bookingRepository.findByGuestAndBookingRequestDateBefore(guest, before);
    }
}
