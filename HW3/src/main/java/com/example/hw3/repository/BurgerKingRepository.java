package com.example.hw3.repository;

import com.example.hw3.domain.BurgerKing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BurgerKingRepository extends JpaRepository<BurgerKing, Integer> {

    BurgerKing findByPrice(Integer price);
    BurgerKing findByName(String name);
    BurgerKing findTopByOrderByCreateTimeDesc();



}
