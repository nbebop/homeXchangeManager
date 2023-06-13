package com.example.homeXchangeManager.service.impl;

import com.example.homeXchangeManager.models.Constraint;
import com.example.homeXchangeManager.repositories.ConstraintRepository;
import com.example.homeXchangeManager.service.ConstraintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstraintServiceImpl implements ConstraintService {
    private ConstraintRepository constraintRepository;

    @Autowired
    public ConstraintServiceImpl(ConstraintRepository constraintRepository) {
        this.constraintRepository = constraintRepository;
    }

    @Override
    public void save(Constraint constraint) {
        constraintRepository.save(constraint);
    }

    @Override
    public List<Constraint> findAll() {
        return constraintRepository.findAll();
    }

}
