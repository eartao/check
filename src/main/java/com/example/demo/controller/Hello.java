package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Hello {
    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

    @RequestMapping("index")
    public  String index(){
        return "index";
    }
}
