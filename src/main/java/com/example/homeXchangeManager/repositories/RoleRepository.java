package com.example.homeXchangeManager.repositories;


import com.example.homeXchangeManager.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    <Optional> Role findByName(String name);
}
