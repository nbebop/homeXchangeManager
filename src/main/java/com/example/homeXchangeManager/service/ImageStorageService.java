package com.example.homeXchangeManager.service;

import com.example.homeXchangeManager.models.Image;
import com.example.homeXchangeManager.models.Listing;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface ImageStorageService {

    void init();

    Resource load(String filename);

    boolean delete(String filename);

    void deleteAll();

    Stream<Path> loadAll();

    List<Image> findByListing(Listing listing);

    Image save(MultipartFile file, Listing listing);

}
