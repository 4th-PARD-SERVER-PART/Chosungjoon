package com.example.hw3.service;

import com.example.hw3.domain.BurgerKing;
import com.example.hw3.dto.BurgerKingDto;
import com.example.hw3.repository.BurgerKingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BurgerKingService {

    private final BurgerKingRepository burgerKingRepository;

    public void save(BurgerKingDto burgerKingDto){
        BurgerKing burgerKing = BurgerKing.builder().name(burgerKingDto.getName()).price(burgerKingDto.getPrice()).build();
        burgerKingRepository.save(burgerKing);
    }
    public String findByPrice(Integer price){
        BurgerKing burgerKing=burgerKingRepository.findByPrice(price);
        return burgerKing.getName();
    }
    public String findByName(String name){
        BurgerKing burgerKing=burgerKingRepository.findByName(name);
        return burgerKing.getName();
    }
    public void update(Long id,BurgerKingDto burgerKingDto){
        BurgerKing burgerKing = burgerKingRepository.findById(id).get();
        burgerKing.setPrice(burgerKingDto.getPrice());
        burgerKing.setName(burgerKingDto.getName());
        burgerKingRepository.save(burgerKing);
    }
    public void delete(Long id){
        burgerKingRepository.deleteById(id);
    }
    public List<BurgerKing> readAll(){
        return burgerKingRepository.findAll();
    }
    public List<BurgerKing> findAllByOrderByCreateTimeDesc(){
        return  burgerKingRepository.findAllByOrderByCreateTimeDesc();


    }


}
