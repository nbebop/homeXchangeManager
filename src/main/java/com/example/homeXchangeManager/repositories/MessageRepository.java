package com.example.homeXchangeManager.repositories;

import com.example.homeXchangeManager.models.Message;
import com.example.homeXchangeManager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findBySenderAndReceiverOrReceiverAndSenderOrderByTimestamp(User sender1, User receiver1, User sender2, User receiver2);
}
