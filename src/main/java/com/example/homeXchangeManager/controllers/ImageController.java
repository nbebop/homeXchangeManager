package com.example.homeXchangeManager.controllers;

import com.example.homeXchangeManager.models.Image;
import com.example.homeXchangeManager.repositories.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ImageController {
    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
    private ImageRepository imageRepository;
    @Autowired
    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

}
