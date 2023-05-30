package com.example.homeXchangeManager.dto;

import com.example.homeXchangeManager.constraints.NameConstraint;
import com.example.homeXchangeManager.constraints.PostalCodeConstraint;
import com.example.homeXchangeManager.constraints.RatingConstraint;
import com.example.homeXchangeManager.models.Constraint;
import com.example.homeXchangeManager.models.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
public class ListingDto {
    private int ownerId;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Address is required")
    private String addressLine;
    @NameConstraint
    private String city;
    @PostalCodeConstraint
    private String postalCode;
    @NameConstraint
    private String country;
    private String premise;
    private List<Service> services;
    private List<Constraint> constrains;
    private String bookingInfo;
    @RatingConstraint
    private double rating;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date availabilityStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date availabilityEnd;

    private MultipartFile mainImg;
    private MultipartFile scdImg;
    private MultipartFile trdImg;

}
