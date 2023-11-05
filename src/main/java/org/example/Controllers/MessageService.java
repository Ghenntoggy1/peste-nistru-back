package org.example.Controllers;

import org.example.Dto.MessageDTO;
import org.example.chatRoom.ChatRoom;
import org.example.chatRoom.ChatRoomRepository;
import org.example.chatRoom.Message;
import org.example.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, ChatRoomRepository chatRoomRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.chatRoomRepository = chatRoomRepository;
        this.userRepository = userRepository;
    }

    public void saveMessage(MessagePayload message) {
        ChatRoom chatRoom = chatRoomRepository.findById(message.getRoomId()).orElse(null);
        if (chatRoom == null) {
            chatRoom = new ChatRoom();
            chatRoom.setRoomName("chat");
            chatRoomRepository.save(chatRoom);
        }
        Message m = new Message();
        m.setChatRoom(chatRoom);
        m.setMessageText(message.getMessage());
        m.setSender(userRepository.findById(message.getSenderId()).get());
        System.out.println(userRepository.findById(message.getSenderId()).get());
        m.setTimestamp(LocalDateTime.now());
        messageRepository.save(m);
    }
    public List<MessageDTO> getMessagesForRoom(Integer roomId) {
        return messageRepository.findByChatRoom_IdOrderByTimestamp(roomId)
                .stream()
                .map(MessageDTO::mapFromMessage)
                .collect(Collectors.toList());
    }
}
