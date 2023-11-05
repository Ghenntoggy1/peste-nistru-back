package org.example.chatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/chatRooms")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }
    @GetMapping("/{userId}")
    public List<ChatRoom> getChatRoomsByUserId(@PathVariable Integer userId) {
        return chatRoomService.getChatRoomsByUserId(userId);
    }
}
