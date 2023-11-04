package org.example.chatRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public List<ChatRoom> getChatRoomsByUserId(Integer userId) {
        // Implement the logic to retrieve chat rooms associated with the user by their user ID
        return chatRoomRepository.findChatRoomsByUserId(userId);
    }
}
