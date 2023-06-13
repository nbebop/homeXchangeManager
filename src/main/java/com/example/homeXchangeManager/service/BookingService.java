package com.example.homeXchangeManager.service;

import com.example.homeXchangeManager.models.Booking;
import com.example.homeXchangeManager.models.User;

import java.util.Date;
import java.util.List;

public interface BookingService {
    void save(Booking booking);

    void delete(int id);

    List<Booking> findByHost(User host);

    List<Booking> findByGuest(User guest);

    Booking findById(int id);

    List<Booking> findByHostAndBookingRequestDateBefore(User guest, Date before);

    List<Booking> findByGuestAndBookingRequestDateBefore(User guest, Date before);

}