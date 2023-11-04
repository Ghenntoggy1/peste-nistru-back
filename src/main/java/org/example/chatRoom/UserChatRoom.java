package org.example.chatRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.user.User;

@Entity
@Table(name = "UserChatRoom")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserChatRoomID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "RoomID", referencedColumnName = "RoomID")
    private ChatRoom chatRoom;
}
