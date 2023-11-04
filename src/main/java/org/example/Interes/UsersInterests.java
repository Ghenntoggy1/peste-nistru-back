package org.example.Interes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.user.User;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UsersInterests")
public class UsersInterests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsersInterestsID")
    private Integer usersInterestsId;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user; // Assuming you have a User entity

    @ManyToOne
    @JoinColumn(name = "InterestID")
    private Interests interest;
}