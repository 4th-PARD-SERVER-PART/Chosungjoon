package com.example.assignment2.mbti.service;

import com.example.assignment2.mbti.dto.Mbtidto;
import com.example.assignment2.mbti.entity.Mbti;
import com.example.assignment2.mbti.repository.Mbtirepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class Mbtiservice {
    private final Mbtirepository mbtirepository;

    public void saveMbti(Mbtidto mbtidto) {
        mbtirepository.save(mbtidto);
    }
    public Mbtidto findByMbti_type(String mbti_type) {
        return mbtirepository.findByMbti_type(mbti_type);
    }
    public Map<String,Mbti> findAll() {
        return mbtirepository.findAll();
    }
}
