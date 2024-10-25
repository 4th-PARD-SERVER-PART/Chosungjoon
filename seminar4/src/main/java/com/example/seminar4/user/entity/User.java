package com.example.seminar4.user.entity;

import com.example.seminar4.book.entity.Book;
import com.example.seminar4.card.entity.Card;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Book> book;

    @OneToOne(mappedBy = "user")
    private Card card;

    public void assignCard(Card card) {
        this.card = card;
    }
}

