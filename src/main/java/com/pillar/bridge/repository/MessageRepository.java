package com.pillar.bridge.repository;
import com.pillar.bridge.entitiy.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages, Integer> {
}