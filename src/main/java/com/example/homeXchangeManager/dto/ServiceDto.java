package com.example.homeXchangeManager.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ServiceDto {
    @NotBlank(message = "Service name is required")
    private String serviceName;
    @NotBlank(message = "Service name is required")
    private String serviceDescription;
}
