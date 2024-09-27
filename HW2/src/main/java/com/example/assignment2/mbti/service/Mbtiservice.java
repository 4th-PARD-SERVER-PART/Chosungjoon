package com.example.assignment2.mbti.service;

import com.example.assignment2.mbti.dto.Mbtidto;
import com.example.assignment2.mbti.entity.Mbti;
import com.example.assignment2.mbti.repository.Mbtirepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    public void update(Mbtidto mbtidto) {
        mbtirepository.save(mbtidto);
    }
    public void delete(String mbti_type){
        mbtirepository.delete(mbti_type);
    }
}
