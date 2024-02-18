package com.pillar.bridge.repository;
import com.pillar.bridge.entitiy.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Messages, Integer> {
    @Query("SELECT m FROM Messages m WHERE m.dialogue.dialogueId = :dialogueId")
    List<Messages> findByFullDialogue(@Param("dialogueId") String dialogueId);

    @Query("SELECT m FROM Messages m WHERE m.dialogue.dialogueId = ?1 ORDER BY m.timestamp DESC")
    List<Messages> findByDialogueId(String dialogueId);
}