package com.example.homeXchangeManager.service.impl;

import com.example.homeXchangeManager.dto.ListingDto;
import com.example.homeXchangeManager.models.Image;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import com.example.homeXchangeManager.repositories.ListingRepository;
import com.example.homeXchangeManager.service.ListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final ListingRepository listingRepository;

    private ImageStorageServiceImpl imageService;


    @Autowired
    public ListingServiceImpl(ListingRepository listingRepository, ImageStorageServiceImpl imageService) {
        this.listingRepository = listingRepository;
        this.imageService = imageService;
    }

    @Override
    public void save(ListingDto listingDto) {
        Listing listing = new Listing();
        listingRepository.save(listing);
    }

    @Override
    public void save(ListingDto listingDto, MultipartFile[] images) {
        Listing listing = new Listing();

        listing.setOwner(listingDto.getOwner());
        listing.setDescription(listingDto.getDescription());
        listing.setServices(listingDto.getServices());
        listing.setConstraints(listingDto.getConstraints());
        listing.setBookingInfo(listingDto.getBookingInfo());
        listing.setAvailabilityStart(listingDto.getAvailabilityStart());
        listing.setAvailabilityEnd(listingDto.getAvailabilityEnd());
        listing.setRating(0.0);
        listing.setOwnerRating(0.0);
        listing.setAddressLine(listingDto.getAddressLine());
        listing.setPremise(listingDto.getPremise());
        listing.setCity(listingDto.getCity());
        listing.setPostalCode(listingDto.getPostalCode());
        listing.setCountry(listingDto.getCountry());
        Listing savedListing = listingRepository.saveAndFlush(listing);

        for (MultipartFile image : images) {
            Image saveImage = imageService.save(image, savedListing);
            savedListing.getImages().add(saveImage);
        }
    }

    @Override
    public void edit(long id, ListingDto updatedListing, MultipartFile[] images) {
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

        for (MultipartFile image : images) {
            Image saveImage = imageService.save(image, listing);
            listing.getImages().add(saveImage);
        }

        listingRepository.save(listing);

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
    public Listing findByOwner(User owner) {
        return listingRepository.findByOwner(owner);
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
    public List<Listing> findAll(Sort sort) {
        return listingRepository.findAll(sort);
    }

    @Override
    public long count() {
        return listingRepository.count();
    }

    @Override
    public List<Listing> findAllByCityAndAvailabilityStartBetween(String city, Date start, Date end) {
        return listingRepository.findAllByCityAndAvailabilityStartBetween(city, start, end);
    }

    @Override
    public List<Listing> findByCityAndAvailabilityStartGreaterThanEqualAndAvailabilityEndLessThanEqual(String city, Date start, Date end) {
        return listingRepository.findByCityAndAvailabilityStartGreaterThanEqualAndAvailabilityEndLessThanEqual(city, start, end);
    }

}
