package com.example.homeXchangeManager.service.impl;

import com.example.homeXchangeManager.controllers.ListingController;
import com.example.homeXchangeManager.models.Image;
import com.example.homeXchangeManager.models.Listing;
import com.example.homeXchangeManager.repositories.ImageRepository;
import com.example.homeXchangeManager.service.ImageStorageService;
import com.example.homeXchangeManager.utils.FileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ImageStorageServiceImpl implements ImageStorageService {

    @Value("${uploadDir}")
    private String uploadPath;

    private static final Logger logger = LoggerFactory.getLogger(ImageStorageServiceImpl.class);

    private final Path root = Paths.get("./uploads");

    private final ImageRepository imageRepository;

    @Autowired
    public ImageStorageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize upload folder!");
        }
    }

    @Override
    public Image save(MultipartFile file, Listing listing) {
        String uploadDir = "/listing-images/" + listing.getListingId();

        logger.debug("directory: " + uploadDir);

        Image img = new Image();

        try {
            String imgName = StringUtils.cleanPath(file.getOriginalFilename());
            imgName = FileUploadUtil.sanitizeFileName(imgName);
            FileUploadUtil.saveFile(uploadDir, file, imgName);
            // save Image to DB
            img.setName(imgName);
            img.setListing(listing);
            img.setUrl(uploadDir + "/" + imgName);
            img.setContentType(file.getContentType());
            imageRepository.save(img);

            logger.debug(imgName + " uploaded successfully");

        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("Filename already exists.");
            }
            logger.debug(file.getOriginalFilename() + " upload failed: " + e.getMessage());

            throw new RuntimeException(e.getMessage());
        }

        return img;
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the image!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public boolean delete(String filename) {
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the images!");
        }
    }

    @Override
    public List<Image> findByListing(Listing listing) {
        return imageRepository.findByListing(listing);
    }
}

