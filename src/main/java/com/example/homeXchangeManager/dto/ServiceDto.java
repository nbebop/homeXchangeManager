package com.example.homeXchangeManager.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class ServiceDto {
    @NotNull
    private String serviceName;
    @NotNull
    private String serviceDescription;
}
