package org.example.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer id;

    @Column(name = "Username", nullable = false)
    private String username;
    @Column(name = "RealName", nullable = false)
    private String realName;
    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

}

