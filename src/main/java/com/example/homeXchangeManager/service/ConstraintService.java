package com.example.homeXchangeManager.service;

import com.example.homeXchangeManager.models.Constraint;

import java.util.List;

public interface ConstraintService {
    void save(Constraint constraint);

    List<Constraint> findAll();
}
