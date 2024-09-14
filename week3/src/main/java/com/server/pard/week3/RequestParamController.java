package com.server.pard.week3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    @RequestMapping("/v4")
    public String param4(@RequestParam String name,@RequestParam(required=false) Integer age){
        if(age==null){
            return "4번 request param " +name+" age: 입력칸 없음";
        }
        return "4 request param: "+name+" age: "+age;
    }
    @RequestMapping("/v5")
    public String param5(@RequestParam(required = true,defaultValue="파드") String name,@RequestParam(required=false,defaultValue = "-1") Integer age){
        return "5 request param: "+name+" age: "+age;
    }
    @RequestMapping("/v6")
    public String param6(@RequestParam Map<String,Object> map){
        return "6 request param: "+map.get("name")+map.get("age");
    }



}
