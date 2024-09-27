package com.example.assignment2.mbti.controller;

import com.example.assignment2.mbti.dto.Mbtidto;
import com.example.assignment2.mbti.entity.Mbti;
import com.example.assignment2.mbti.service.Mbtiservice;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/mbti")
@RestController
@RequiredArgsConstructor
public class Mbticontroller {
    private final Mbtiservice mbtiservice;

    @PostMapping
    public void saveMbti(@RequestBody Mbtidto mbtidto){
        mbtiservice.saveMbti(mbtidto);
    }
    @GetMapping("/{mbti}")
    public Mbtidto findMbti(@PathVariable String mbti){
        return mbtiservice.findByMbti_type(mbti);
    }
    @GetMapping()
    public Map<String,Mbti>findAll(){
        return mbtiservice.findAll();
    }
}
