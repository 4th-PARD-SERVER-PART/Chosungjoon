package com.example.HW5.user.controller;


import com.example.HW5.post.dto.PostDto;
import com.example.HW5.user.dto.UserDto;
import com.example.HW5.user.service.UserService;
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
