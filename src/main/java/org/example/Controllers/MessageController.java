package org.example.Controllers;

import org.example.Dto.MessageDTO;
import org.example.chatRoom.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;
import org.springframework.messaging.handler.annotation.Payload;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final SimpMessageSendingOperations messagingTemplate;
    private final MessageService messageService;

    @Autowired
    public MessageController(SimpMessageSendingOperations messagingTemplate, MessageService messageService) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }

    // Endpoint for sending a message to a chat room
    @MessageMapping("/sendMessage/{roomName}")
    @SendTo("/topic/{roomName}")
    public Message sendMessage(@Payload Message message, @DestinationVariable String roomName) {
        messageService.saveMessage(message, roomName);
        return message;
    }

    @GetMapping("/{roomId}")
    public List<MessageDTO> getMessagesForRoom(@PathVariable Integer roomId) {
        // Retrieve messages for the specified chat room
        return messageService.getMessagesForRoom(roomId);
    }
}