package com.example.hw04.user.controller;


import com.example.hw04.post.dto.PostDto;
import com.example.hw04.user.dto.UserDto;
import com.example.hw04.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserDto.createReq userReq) {
        userService.createUser(userReq);
    }
    @GetMapping("detail/{userId}")
    public UserDto.detailRes detailUser(@PathVariable Long userId) {
        return userService.detail(userId);
    }
    @GetMapping("list/{userId}")
    public List<PostDto.createReq> list(@PathVariable Long userId){
        return userService.list(userId);
    }

    


}
