package com.example.homeXchangeManager.dto;

import com.example.homeXchangeManager.models.Constraint;
import com.example.homeXchangeManager.models.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class ListingDto {
    private int ownerId;
    private String description;
    private String addressLine;
    private String city;
    private String postalCode;
    private String country;
    private String premise;
    private String photos;
    private List<Service> services;
    private List<Constraint> constrains;
    private String bookingInfo;
    private double rating;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date availabilityStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date availabilityEnd;

}
