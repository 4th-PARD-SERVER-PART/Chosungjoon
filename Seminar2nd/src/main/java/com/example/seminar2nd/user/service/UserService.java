package com.example.seminar2nd.user.service;

import com.example.seminar2nd.user.dto.UserDto;
import com.example.seminar2nd.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserDto userDto){
        userRepository.save(userDto);
    }
    public UserDto findById(Long studentId) {
        return userRepository.findByStudentId(studentId);
    }
    public List<UserDto> findAll(){
        return userRepository.findAll();
    }
    public void updateById(@PathVariable Long studentId, @RequestBody UserDto userDto){
        userRepository.update(studentId,userDto);
    }
    public void deleteById(@PathVariable Long studentId){
        userRepository.delete(studentId);
    }

}
