package com.example.homeXchangeManager.dto;

import com.example.homeXchangeManager.models.Address;
import com.example.homeXchangeManager.models.Constraint;
import com.example.homeXchangeManager.models.Service;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ListingDto {
    private int ownerId;
    private String description;
    private Address address;
    private List<String> photos;
    private List<Service> services;
    private List<Constraint> constrains;
    private String bookingInfo;
    private double rating;
    private Date availabilityStart;
    private Date availabilityEnd;

}
