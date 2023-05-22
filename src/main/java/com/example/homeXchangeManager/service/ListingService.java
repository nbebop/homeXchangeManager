package com.example.homeXchangeManager.service;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;

import java.util.List;

public interface ListingService {
    void save(Listing listing);

    void edit(long id, Listing newListing);

    void delete(long id);

    Listing findByListingId(long id);

    List<Listing> findByCountry(String country);

    List<Listing> findByOwner(User owner);

    List<Listing> findByCity(String city);

    List<Listing> findAll();

    long count();

}
