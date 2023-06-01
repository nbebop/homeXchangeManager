package com.example.homeXchangeManager.service;

import com.example.homeXchangeManager.models.Service;

import java.util.List;

public interface ServiceService {
    void save(Service service);

    List<Service> findAll();
}
