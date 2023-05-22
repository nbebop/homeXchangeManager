package com.example.homeXchangeManager.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ConstraintDto {
    @NotBlank(message = "Constraint name is required")
    private String constraintName;
    @NotBlank(message = "Constraint description is required")
    private String constraintDescription;

}
