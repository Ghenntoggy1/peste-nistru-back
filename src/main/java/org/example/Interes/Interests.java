package org.example.Interes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Interests")
public class Interests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InterestID")
    private Integer interestId;

    @Column(name = "InterestRO", nullable = false)
    private String interestRO;

    @Column(name = "InterestRU", nullable = false)
    private String interestRU;

    @Column(name = "InterestEN", nullable = false)
    private String interestEN;
    @Transient
    private Map<String, String> i18n;

}