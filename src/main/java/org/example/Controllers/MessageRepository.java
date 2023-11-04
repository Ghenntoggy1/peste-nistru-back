package org.example.Controllers;

import org.example.chatRoom.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findByChatRoom_IdOrderByTimestamp(Integer roomId);

}

