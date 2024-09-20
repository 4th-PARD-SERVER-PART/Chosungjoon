package com.server.pard.Hw1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pocketmoney")
public class Pocket_money {

    @RequestMapping("pathvariable/{name}")
    public String path2(@PathVariable String name) {
        return "사용자명:"+name;
    }

    @RequestMapping("pathvariable/{name}/{amount}")
    public String path3(@PathVariable String name, @PathVariable Long amount) {
        return "user name: "+name+"/ 용돈:"+amount+"원";
    }
    @RequestMapping("/requestparam")
    public String param1(@RequestParam(required = true,defaultValue = "조성준") String name, @RequestParam Integer amount){
        if(amount==null){
            return "사용자명: "+name +" 용돈 주세요! 용돈 없스무니다";
        }
        return "사용자명: "+name +" 용돈: "+amount+"원";
    }
    @PostMapping("")
    public String postUsers(){
        return"성준이의 스프링부트 Post Method controller";
    }

    @GetMapping("/{amount}")
    public String getUserById(@PathVariable Long amount){
        return "용돈 : "+amount;
    }

    @PatchMapping("/{amount}")
    public String patchUserById(@PathVariable Long amount){
        return amount+"번 유저의 정보를 수정";
    }

    @DeleteMapping("/{amount}")
    public String deleteUser(@PathVariable Long amount){
        return amount+"번 유저의 정보 삭제";
    }
}
