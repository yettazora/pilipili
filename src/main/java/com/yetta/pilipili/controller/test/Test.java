package com.yetta.pilipili.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping("/test.action")
    public String test(){
        System.out.println("测试成功");
        return "test";
    }
}
