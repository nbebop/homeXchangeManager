package com.example.homeXchangeManager.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "listings")
public class Listing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long listingId;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private User owner;

    private String description;
    @Lob
    @Column(name = "image", length = Integer.MAX_VALUE, nullable = true)
    private Byte[] image;

    @ManyToMany
    private List<Service> services;

    @ManyToMany
    private List<Constraint> constraints;

    private String bookingInfo;

    private double rating;

    private double ownerRating;

    // TODO: add in services the logic to get the ratings
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
    @NotNull
    private Date availabilityStart;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
    @NotNull
    private Date availabilityEnd;

    private String addressLine;
    private String premise;
    private String city;
    private String postalCode;
    private String country;

    public Listing() {
    }

    public Listing(long listingId, User owner, String description, Byte[] image, List<Service> services, List<Constraint> constraints, String bookingInfo, double rating, double ownerRating, Date availabilityStart, Date availabilityEnd, String addressLine, String premise, String city, String postalCode, String country) {
        this.listingId = listingId;
        this.owner = owner;
        this.description = description;
        this.image = image;
        this.services = services;
        this.constraints = constraints;
        this.bookingInfo = bookingInfo;
        this.rating = rating;
        this.ownerRating = ownerRating;
        this.availabilityStart = availabilityStart;
        this.availabilityEnd = availabilityEnd;
        this.addressLine = addressLine;
        this.premise = premise;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public long getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraint> constraints) {
        this.constraints = constraints;
    }

    public String getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(String bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getOwnerRating() {
        return ownerRating;
    }

    public void setOwnerRating(double ownerRating) {
        this.ownerRating = ownerRating;
    }

    public Date getAvailabilityStart() {
        return availabilityStart;
    }

    public void setAvailabilityStart(Date availabilityStart) {
        this.availabilityStart = availabilityStart;
    }

    public Date getAvailabilityEnd() {
        return availabilityEnd;
    }

    public void setAvailabilityEnd(Date availabilityEnd) {
        this.availabilityEnd = availabilityEnd;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }
}
