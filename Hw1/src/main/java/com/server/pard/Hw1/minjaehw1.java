package com.server.pard.Hw1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class minjaehw1 {

    @RequestMapping("/path/{name}/{age}/{school}/{major}/{mbti}")
    public String path(@PathVariable String name, @PathVariable int age
            , @PathVariable String school, @PathVariable String major, @PathVariable String  mbti) {
        return "안녕하세요. 저의 자기소개를 하겠습니다. 저의 이름은 " + name + " 입니다. 저는 " + age + "입니다. 학교는 " + school +
                "이고, 전공은 " + major + "입니다. 마지막으로 저의 mbti는 " + mbti + "입니다. 감사합니다.";
    }

}
