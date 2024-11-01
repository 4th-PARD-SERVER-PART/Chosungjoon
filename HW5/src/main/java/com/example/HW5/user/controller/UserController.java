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

    @GetMapping("detail/{email}")
    public UserDto.detailRes detailUser(@PathVariable String email) {
        return userService.detail(email);
    }
    @GetMapping("list/{Email}")
    public List<PostDto.createReq> list(@PathVariable String Email){
        return userService.list(Email);
    }

    


}
