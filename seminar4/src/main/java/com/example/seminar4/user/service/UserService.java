package com.example.seminar4.user.service;


import com.example.seminar4.user.dto.UserRequest;
import com.example.seminar4.user.dto.UserResponse;
import com.example.seminar4.user.entity.User;
import com.example.seminar4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public UserResponse.ReadUser readUser(Long id){
        Optional<User>users=userRepo.findById(id);
        User user=users.get();
        UserResponse.ReadUser userResponse=UserResponse.ReadUser.from(user);
        return userResponse;
    }
    public void createUser(UserRequest.UserCreateRequest req) {
        User user = new User(null, req.getName(),req.getBooks(),null);
        userRepo.save(user);
    }
    public void deleteUser(Long userId){
        User user=userRepo.findById(userId).orElseThrow(IllegalAccessError::new);
        userRepo.delete(user);
    }

}
