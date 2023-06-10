package com.example.homeXchangeManager.repositories;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.ListingRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRatingRepository extends JpaRepository<ListingRating, Integer> {
    ListingRating save(ListingRating l);

    List<ListingRating> findByListing(Listing l);

}
