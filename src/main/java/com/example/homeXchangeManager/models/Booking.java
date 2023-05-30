package com.example.homeXchangeManager.models;

import com.example.homeXchangeManager.constraints.StayTimeConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@StayTimeConstraint
@Entity
@Table(name = "booking")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "guestId", nullable = false)
    private User guest;

    @ManyToOne
    @JoinColumn(name = "listingId", nullable = false)
    private Listing listing;

    @NotNull
    private Date bookingStart;

    @NotNull
    private Date bookingEnd;

    private String additionalInfo;

    // Constructor
    public Booking() {}

    public Booking(User guest, Listing listing, Date bookingStart, Date bookingEnd, String additionalInfo) {
        this.guest = guest;
        this.listing = listing;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
        this.additionalInfo = additionalInfo;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getGuest() {
        return guest;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public Date getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(Date bookingStart) {
        this.bookingStart = bookingStart;
    }

    public Date getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(Date bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
