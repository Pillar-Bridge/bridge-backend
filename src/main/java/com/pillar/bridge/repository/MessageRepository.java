package com.pillar.bridge.repository;
import com.pillar.bridge.entitiy.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Messages, Integer> {
    List<Messages> findByFullDialogue(String dialogueId);
}