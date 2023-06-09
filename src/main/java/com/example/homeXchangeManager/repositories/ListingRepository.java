package com.example.homeXchangeManager.repositories;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer> {
    Listing save(Listing l);

    @Override
    <S extends Listing> S saveAndFlush(S entity);

    List<Listing> findAllByOwner(User owner);

    Listing findByOwner(User owner);

    Listing deleteListingByListingId(long listingId);

    Listing findListingByListingId(long listingId);

    List<Listing> findAllByCountry(String country);

    List<Listing> findAllByCity(String city);

    List<Listing> findAllByOrderByListingIdAsc();

    List<Listing> findAllByCityAndAvailabilityStartBetween(String city, Date start, Date end);

    List<Listing> findByCityAndAvailabilityStartGreaterThanEqualAndAvailabilityEndLessThanEqual(String city, Date start, Date end);
}
