package com.example.week4.user.service;

import com.example.week4.user.dto.UserDto;
import com.example.week4.user.entity.User;
import com.example.week4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public void save(UserDto userdto){
        User user=User.builder().email(userdto.getEmail()).password(userdto.getPassword()).build();
        repository.save(user);
    }
    public UserDto read(Long id){
        User user=repository.findById(id).orElse(null);
        return UserDto.builder().email(user.getEmail()).password(user.getPassword()).build();
    }
    public List<UserDto> readAll(){
        List<User>users=repository.findAll();
        List<UserDto>userdtos=users.stream().map(user-> UserDto.builder().email(user.getEmail()).password(user.getPassword()).build()).toList();
        return userdtos;
    }
    public void update(Long id, UserDto userdto){
        User user=repository.findById(id).orElse(null);
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        repository.save(user);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public Long getUserNum(String email){
        User user=repository.findByEmail(email);
        return user.getId();
    }
}
