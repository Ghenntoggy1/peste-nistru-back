package org.example.Controllers;

import org.example.Dto.MessageDTO;
import org.example.chatRoom.ChatRoom;
import org.example.chatRoom.ChatRoomRepository;
import org.example.chatRoom.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, ChatRoomRepository chatRoomRepository) {
        this.messageRepository = messageRepository;
        this.chatRoomRepository = chatRoomRepository;
    }

    public Message saveMessage(Message message, String roomName) {
        ChatRoom chatRoom = chatRoomRepository.findByRoomName(roomName);
        if (chatRoom == null) {
            chatRoom = new ChatRoom();
            chatRoom.setRoomName(roomName);
            chatRoomRepository.save(chatRoom);
        }
        message.setChatRoom(chatRoom);
        return messageRepository.save(message);
    }
    public List<MessageDTO> getMessagesForRoom(Integer roomId) {
        return messageRepository.findByChatRoom_IdOrderByTimestamp(roomId)
                .stream()
                .map(MessageDTO::mapFromMessage)
                .collect(Collectors.toList());
    }
}
