package com.example.week4.user.controller;


import com.example.week4.user.dto.UserDto;
import com.example.week4.user.entity.User;
import com.example.week4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("")
    public void save(@RequestBody UserDto userdto) {
        userService.save(userdto);
    }
    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return userService.read(id);
    }
    @GetMapping("")
    public List<UserDto> readAll() {
        return userService.readAll();
    }
    @PatchMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody UserDto userdto){
        userService.update(id,userdto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
    @GetMapping("/userNum")
    public ResponseEntity<Long> getUserNum(@RequestParam String email) {
        Long reposnseValue= userService.getUserNum(email);
        return new ResponseEntity<>(reposnseValue, HttpStatus.OK);
    }
    }



