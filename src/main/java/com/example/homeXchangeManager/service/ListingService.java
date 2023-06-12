package com.example.homeXchangeManager.service;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface ListingService {
    void save(ListingDto listing);

    void save(ListingDto listing, MultipartFile[] images);

    //Listing saveAndFlush(Listing listing);


    void edit(long id, ListingDto newListing, MultipartFile[] images);

    void delete(long id);

    Listing findByListingId(long id);

    List<Listing> findByCountry(String country);

    Listing findByOwner(User owner);

    List<Listing> findByCity(String city);

    List<Listing> findAll();

    List<Listing> findAllByCityAndAvailabilityStartBetween(String city, Date start, Date end);

    List<Listing> findByCityAndAvailabilityStartGreaterThanEqualAndAvailabilityEndLessThanEqual(String city, Date start, Date end);

    long count();

    //void save(ListingDto listing, MultipartFile[] images);

}
