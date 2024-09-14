package com.server.pard.week3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {
    @RequestMapping("/v1")
    public String param1(@RequestParam("name")String name,@RequestParam("age")int age){
        return "Request Param 1번: "+name +" 나이: "+age;
    }
    @RequestMapping("/v2")
    public String param2(@RequestParam String name, @RequestParam int age){
        return "Request Param 2번: "+name +" 나이: "+age;
    }
    @RequestMapping("/v3")
    //아무것도 안 붙이면 기본적으로 Requestparam이 적용된다
    public String param3(String name,int age){
        return "Parameter name 3번: "+name +" 나이: "+age;
    }

}
