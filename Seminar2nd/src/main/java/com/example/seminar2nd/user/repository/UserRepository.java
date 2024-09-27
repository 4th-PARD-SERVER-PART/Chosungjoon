package com.example.seminar2nd.user.repository;

import com.example.seminar2nd.user.dto.UserDto;
import com.example.seminar2nd.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserRepository{
    private static final Map<Long, User> handong = new HashMap<>();

    public void save(UserDto userDto){
        User user= User.builder().studentId(userDto.getStudentId()).studentName(userDto.getStudentName()).build();
        handong.put(userDto.getStudentId(),user);
    }

    public UserDto findByStudentId(Long studentId){
        User user=handong.get(studentId);
        return UserDto.builder().StudentId(user.getStudentId()).studentName(user.getStudentName()).build();
    }
    public List<UserDto> findAll(){
        return handong.values().stream().map(user->UserDto.builder().StudentId(user.getStudentId()).studentName(user.getStudentName()).build()).toList();
    }
    public void update(Long studentId, UserDto userDto){
        User user=handong.get(studentId);
        userDto.setStudentId(studentId);
        handong.put(studentId,user);
    }
    public void delete(Long studentId){
        User user=handong.get(studentId);
        handong.remove(studentId);
    }
}
