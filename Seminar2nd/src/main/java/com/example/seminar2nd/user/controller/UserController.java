package com.example.seminar2nd.user.controller;


import com.example.seminar2nd.user.dto.UserDto;
import com.example.seminar2nd.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    @PostMapping
    public String saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return "확인됐음요";
    }
    @GetMapping("/{studentId}")
    public UserDto findById(@PathVariable Long studentId){
        return userService.findById(studentId);
    }
    @GetMapping("")
    public List<UserDto> findAll(){
        return userService.findAll();
    }
    @PatchMapping("/{studentId}")
    public String updateById(@PathVariable Long studentId, @RequestBody UserDto userDto){
        userService.updateById(studentId,userDto);
        return "수정됐음요";
    }
    @DeleteMapping("/{studentId}")
    public String deleteById(@PathVariable Long studentId){
        userService.deleteById(studentId);
        return "삭제됐음요";
    }

}
