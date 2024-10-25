package com.example.hw3.controller;

import com.example.hw3.domain.BurgerKing;
import com.example.hw3.dto.BurgerKingDto;
import com.example.hw3.service.BurgerKingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burg")
@RequiredArgsConstructor
public class BurgerKingController {
    private final BurgerKingService burgerKingService;

    @PostMapping("")
    public void save(@RequestBody BurgerKingDto burgerKingDto) {
        burgerKingService.save(burgerKingDto);
    }
    @GetMapping("/price/{price}")
    public String findByPrice(@PathVariable Integer price){
        System.out.println(price);
        return burgerKingService.findByPrice(price);
    }
    @GetMapping("/name/{name}")
    public String findByPrice(@PathVariable String name){
        return burgerKingService.findByName(name);
    }
    @GetMapping("")
    public List<BurgerKing> readAll(){
        return burgerKingService.readAll();
    }
    @PatchMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody BurgerKingDto burgerKingDto){
        burgerKingService.update(id,burgerKingDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        burgerKingService.delete(id);
    }
    @GetMapping("/findByTime")
    public List<BurgerKing> findAllByOrderByCreateTimeDesc(){
        return burgerKingService.findAllByOrderByCreateTimeDesc();
    }


}
