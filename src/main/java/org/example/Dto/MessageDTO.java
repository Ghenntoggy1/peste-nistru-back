package org.example.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.chatRoom.ChatRoom;
import org.example.chatRoom.Message;
import org.example.user.User;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    private String sender;

    private String messageText;

    private LocalDateTime timestamp;

    public static MessageDTO mapFromMessage(Message message){
        return new MessageDTO(
                message.getSender().getRealName(),
                message.getMessageText(),
                message.getTimestamp()
                );
    }
}
