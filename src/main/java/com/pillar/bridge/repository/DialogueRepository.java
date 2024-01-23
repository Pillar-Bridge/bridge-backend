package com.pillar.bridge.repository;

import com.pillar.bridge.entitiy.Dialogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialogueRepository extends JpaRepository<Dialogue, Integer> {
}
