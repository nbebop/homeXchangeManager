package com.example.homeXchangeManager.constraints;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class FileConstraintValidator implements ConstraintValidator<FileConstraint, MultipartFile> {
    private static final String[] ALLOWED_CONTENT_TYPES = {"image/jpeg", "image/png", "image/jpg", "image/gif", "image/tiff", "image/heic"};
    private static final long MAX_FILE_SIZE = 1000 * 1024 * 1024; // 1000MB

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; // Skip validation if the value is null or empty
        }
        // Check if the content type is allowed
        if (!Arrays.asList(ALLOWED_CONTENT_TYPES).contains(value.getContentType())) {
            return false;
        }
        // Check if the file size is within the allowed limit
        return value.getSize() <= MAX_FILE_SIZE;
    }
}

