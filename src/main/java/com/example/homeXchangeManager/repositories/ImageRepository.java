package com.example.homeXchangeManager.repositories;

import com.example.homeXchangeManager.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Override
    List<Image> findAll();
}
