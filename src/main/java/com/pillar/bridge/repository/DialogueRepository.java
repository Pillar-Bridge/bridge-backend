package com.pillar.bridge.repository;

import com.pillar.bridge.entitiy.Dialogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DialogueRepository extends JpaRepository<Dialogue, String> {
    Optional<Dialogue> findByDialogueId(String dialogueId);
}

