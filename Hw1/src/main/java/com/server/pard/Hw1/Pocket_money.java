package com.server.pard.Hw1;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pocketmoney")
public class Pocket_money {

    // In-memory storage to simulate users
    private Map<Long, String> userData = new HashMap<>();

    // Constructor to pre-fill some data for testing
    public Pocket_money() {
        userData.put(500000L, "조성준");
    }

    @RequestMapping("pathvariable/{name}")
    public String path2(@PathVariable String name) {
        return "사용자명:" + name;
    }

    @RequestMapping("pathvariable/{name}/{amount}")
    public String path3(@PathVariable String name, @PathVariable Long amount) {
        return "user name: " + name + " / 용돈:" + amount + "원";
    }

    @RequestMapping("/requestparam")
    public String param1(@RequestParam(required = true, defaultValue = "조성준") String name, @RequestParam Integer amount) {
        if (amount == null) {
            return "사용자명: " + name + " 용돈 주세요! 용돈 없스무니다";
        }
        return "사용자명: " + name + " 용돈: " + amount + "원";
    }

    @PostMapping("")
    public String postUsers() {
        return "성준이의 스프링부트 Post Method controller";
    }

    @GetMapping("/{amount}")
    public String getUserById(@PathVariable Long amount) {
        String name = userData.get(amount);
        if (name != null) {
            return "용돈 : " + amount + "원, 사용자명 : " + name;
        }
        return "해당 용돈 금액에 해당하는 사용자가 없습니다.";
    }

    @PatchMapping("/{amount}")
    public String patchUserById(@PathVariable Long amount, @RequestParam String name) {
        if (userData.containsKey(amount)) {
            userData.put(amount, name); // Update user name
            return amount + "번 유저의 정보가 " + name + "로 수정되었습니다.";
        } else {
            return amount + "번 유저를 찾을 수 없습니다.";
        }
    }

    @DeleteMapping("/{amount}")
    public String deleteUser(@PathVariable Long amount) {
        if (userData.containsKey(amount)) {
            userData.remove(amount); // Delete the user
            return amount + "번 유저의 정보가 삭제되었습니다.";
        } else {
            return amount + "번 유저를 찾을 수 없습니다.";
        }
    }
}
