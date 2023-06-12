package com.example.homeXchangeManager.service.impl;

import com.example.homeXchangeManager.dto.RatingDto;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.ListingRating;
import com.example.homeXchangeManager.repositories.ListingRatingRepository;
import com.example.homeXchangeManager.service.ListingRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ListingRatingServiceImpl implements ListingRatingService {
    private static final Logger logger = LoggerFactory.getLogger(ListingRatingServiceImpl.class);

    private final ListingServiceImpl listingService;
    private final UserServiceImpl userService;
    private final ListingRatingRepository ratingRepository;


    @Autowired
    public ListingRatingServiceImpl(ListingServiceImpl listingService, UserServiceImpl userService,
                                    ListingRatingRepository ratingRepository) {
        this.listingService = listingService;
        this.userService = userService;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void save(RatingDto ratingDto) {
        ListingRating rating = new ListingRating();
        rating.setListing(listingService.findByListingId(ratingDto.getListingId()));
        rating.setReviewer(userService.findById(ratingDto.getReviewerId()));
        rating.setDescription(ratingDto.getDescription());
        rating.setScore(ratingDto.getScore());
        rating.setReviewDate(new Date());
        ratingRepository.save(rating);
    }

    @Override
    public double calculateAverageRating(Listing listing) {
        List<ListingRating> listingRatings = ratingRepository.findByListing(listing);

        double averageRating = listingRatings.stream()
                .mapToInt(ListingRating::getScore)
                .average()
                .orElse(0.0);

        return averageRating;
    }

}
