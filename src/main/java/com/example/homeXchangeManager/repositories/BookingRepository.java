package com.example.homeXchangeManager.repositories;


import com.example.homeXchangeManager.models.Booking;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByHost(User host);

    List<Booking> findByGuest(User guest);

    List<Booking> findByListing(Listing listing);

    Booking findByBookingId(int id);

    List<Booking> findByHostAndBookingRequestDateBefore(User host, Date currentDate);
}
