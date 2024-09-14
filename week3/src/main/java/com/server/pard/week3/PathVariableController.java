package com.server.pard.week3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {
    @RequestMapping("/path1/{name}")
    public String path1(@PathVariable("name") String name) {
        return "1번 path variable controller name:"+name;
    }

    @RequestMapping("/path2/{name}")
    public String path2(@PathVariable String name) {
        return "2번 path variable name:"+name;
    }

    @RequestMapping("/path3/{name}/{age}")
    public String path3(@PathVariable String name, @PathVariable Long age) {
        return "3번 user name: "+name+"/ 나이:"+age;
    }

}
