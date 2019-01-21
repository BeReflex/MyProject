package com.example.springboot_demo_first;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    String HelloWorld(){
        return "Hello new World!!";
    }
}
