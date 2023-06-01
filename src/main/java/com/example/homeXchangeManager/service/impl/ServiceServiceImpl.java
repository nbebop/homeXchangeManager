package com.example.homeXchangeManager.service.impl;

import com.example.homeXchangeManager.repositories.ServiceRepository;
import com.example.homeXchangeManager.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void save(com.example.homeXchangeManager.models.Service constraint) {
        serviceRepository.save(constraint);
    }

    @Override
    public List<com.example.homeXchangeManager.models.Service> findAll() {
        return serviceRepository.findAll();
    }

}
