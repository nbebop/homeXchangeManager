package com.example.homeXchangeManager.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ConstraintDto {
    @NotNull
    private String constraintName;
    @NotNull
    private String constraintDescription;

}
