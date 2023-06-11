package com.example.homeXchangeManager.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RatingDto {
    private int reviewerId;
    private int listingId;
    @NotNull
    private int score;
    @NotBlank(message = "A description is required to submit a review")
    private String description;
}
