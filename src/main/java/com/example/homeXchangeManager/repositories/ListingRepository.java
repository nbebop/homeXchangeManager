package com.example.homeXchangeManager.repositories;

import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer> {
    List<Listing> findAllByOwner(User owner);
}
