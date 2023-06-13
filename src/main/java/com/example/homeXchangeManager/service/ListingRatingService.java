package com.example.homeXchangeManager.service;

import com.example.homeXchangeManager.dto.RatingDto;
import com.example.homeXchangeManager.models.Listing;

public interface ListingRatingService {
    void save(RatingDto ratingDto);

    double calculateAverageRating(Listing listing);
}
