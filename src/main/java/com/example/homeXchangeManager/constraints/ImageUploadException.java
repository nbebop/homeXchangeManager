package com.example.homeXchangeManager.constraints;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ImageUploadException {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(Model model, MaxUploadSizeExceededException e) {
        List<String> messages = new ArrayList<>();
        messages.add("One of selected images is too large!");

        model.addAttribute("messages", messages);

        return "new_listing";
    }
}
