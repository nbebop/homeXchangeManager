package com.example.homeXchangeManager.repositories;

import com.example.homeXchangeManager.models.Image;
import com.example.homeXchangeManager.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAll();

    List<Image> findByListing(Listing listing);

}
