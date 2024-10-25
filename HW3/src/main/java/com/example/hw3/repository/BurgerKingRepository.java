package com.example.hw3.repository;

import com.example.hw3.domain.BurgerKing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BurgerKingRepository extends JpaRepository<BurgerKing, Long> {

    BurgerKing findByPrice(int price);
    BurgerKing findByName(String name);
    List<BurgerKing> findAllByOrderByCreateTimeDesc();


}
