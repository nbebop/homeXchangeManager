package com.example.homeXchangeManager.repositories;

import com.example.homeXchangeManager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.homeXchangeManager.models.User;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
