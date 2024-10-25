package com.example.seminar4.card.repo;

import com.example.seminar4.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {
}
