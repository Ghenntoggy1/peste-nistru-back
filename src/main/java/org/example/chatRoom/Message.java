package org.example.chatRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "Messages")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MessageID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "RoomID", referencedColumnName = "RoomID")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "SenderID", referencedColumnName = "UserID")
    private User sender;

    @Column(name = "MessageText", nullable = false, columnDefinition = "TEXT")
    private String messageText;

    @Column(name = "Timestamp")
    private LocalDateTime timestamp;
}