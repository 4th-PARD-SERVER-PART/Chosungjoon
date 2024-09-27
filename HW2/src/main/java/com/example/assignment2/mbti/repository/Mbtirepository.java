package com.example.assignment2.mbti.repository;


import com.example.assignment2.mbti.dto.Mbtidto;
import com.example.assignment2.mbti.entity.Mbti;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class Mbtirepository {
    private static final Map<String,Mbti> mbtiList=new HashMap<>();
    public void save(Mbtidto mbtidto){
        Mbti mbti= Mbti.builder().mbti_type(mbtidto.getMbti_type()).mbti_nick(mbtidto.getMbti_nick()).build();
        mbtiList.put(mbtidto.getMbti_type(),mbti);
    }
    public Mbtidto findByMbti_type(String mbti_type){
        Mbti mbti=mbtiList.get(mbti_type);
        return Mbtidto.builder().mbti_type(mbti.getMbti_type()).mbti_nick(mbti.getMbti_nick()).build();
    }
    public Map<String,Mbti> findAll(){
        return mbtiList;
    }
    public void update(String mbti_type,Mbtidto mbtidto){
        Mbti mbti=mbtiList.get(mbti_type);
        mbti.setMbti_type(mbtidto.getMbti_type());
        mbti.setMbti_nick(mbtidto.getMbti_nick());
        mbtiList.put(mbti_type,mbti);
    }

    public void delete(String mbti_type){
        mbtiList.remove(mbti_type);
    }

}
