package com.example.homeXchangeManager.models;

import com.example.homeXchangeManager.constraints.StayTimeConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@StayTimeConstraint
@Entity
@Table(name = "bookings")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "guestId", nullable = false)
    private User guest;

    @ManyToOne
    @JoinColumn(name = "hostId", nullable = false)
    private User host;

    @ManyToOne
    @JoinColumn(name = "listingId", nullable = false)
    private Listing listing;

    @NotNull
    private Date bookingStart;

    @NotNull
    private Date bookingEnd;

    private String additionalInfo;

    private Date bookingRequestDate;

    private boolean accepted;

    public Booking() {
    }

    public Booking(int bookingId, User guest, User host, Listing listing, Date bookingStart, Date bookingEnd, String additionalInfo, Date bookingRequestDate, boolean accepted) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.host = host;
        this.listing = listing;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
        this.additionalInfo = additionalInfo;
        this.bookingRequestDate = bookingRequestDate;
        this.accepted = accepted;
    }

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

    public Date getBookingRequestDate() {
        return bookingRequestDate;
    }

    public void setBookingRequestDate(Date bookingRequestDate) {
        this.bookingRequestDate = bookingRequestDate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }
}