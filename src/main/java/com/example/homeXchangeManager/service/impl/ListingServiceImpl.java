package com.example.homeXchangeManager.service.impl;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.ListingRepository;
import com.example.homeXchangeManager.service.ListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final ListingRepository listingRepository;

    @Autowired
    public ListingServiceImpl(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @Override
    public void save(Listing listing) {
        listingRepository.save(listing);
    }

    @Override
    public void edit(long id, Listing updatedListing) {
        Listing listing = listingRepository.getById((int) id);

        listing.setDescription(updatedListing.getDescription());
        //listing.setImage(updatedListing.getImage());
        listing.setServices(updatedListing.getServices());
        listing.setConstraints(updatedListing.getConstraints());
        listing.setBookingInfo(updatedListing.getBookingInfo());
        listing.setAvailabilityStart(updatedListing.getAvailabilityStart());
        listing.setAvailabilityEnd(updatedListing.getAvailabilityEnd());
        listing.setAddressLine(updatedListing.getAddressLine());
        listing.setPremise(updatedListing.getPremise());
        listing.setCity(updatedListing.getCity());
        listing.setPostalCode(updatedListing.getPostalCode());
        listing.setCountry(updatedListing.getCountry());
        save(listing);
    }

    @Override
    public void delete(long id) {
        listingRepository.delete(findByListingId(id));
    }

    @Override
    public Listing findByListingId(long id) {
        return listingRepository.findListingByListingId(id);
    }

    @Override
    public List<Listing> findByCountry(String country) {
        return listingRepository.findAllByCountry(country);
    }

    @Override
    public List<Listing> findByOwner(User owner) {
        return listingRepository.findAllByOwner(owner);
    }

    @Override
    public List<Listing> findByCity(String city) {
        return listingRepository.findAllByCity(city);
    }

    @Override
    public List<Listing> findAll() {
        return listingRepository.findAllByOrderByListingIdAsc();
    }

    @Override
    public long count() {
        return listingRepository.count();
    }

}
