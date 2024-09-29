package com.example.hw3.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BurgerKing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="BurgerKingName",length=28)
    private String name;
    @Column(name="price",length=20)
    private Integer price;

    @CreationTimestamp
    private LocalDateTime createTime;


}
