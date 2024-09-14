package com.server.pard.week3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RestMethodController {
    @GetMapping("")
    public String getUsers(){
        return"Get Method controller";
    }

    @PostMapping("")
    public String postUsers(){
        return"성준이의 스프링부트 Post Method controller";
    }

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable Long userId){
        return "userId : "+userId;
    }

    @PatchMapping("/{userId}")
    public String patchUserById(@PathVariable Long userId){
        return userId+"번 유저의 정보를 수정";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return userId+"번 유저의 정보 삭제";
    }

}

