package com.example.demo;
 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheadController   {

 
 
    @RequestMapping("/")
    void home() {
        
        Cus c = new Cus();
        System.out.println("线程非安全例子：");
        
        for (int i = 0; i < 3; i++) {
            new Thread(c).start();
        }
        
        syn s = new syn();
        System.out.println("线程安全例子：");
        for (int i = 0; i < 3; i++) {
            new Thread(s).start();
        }
             
    }
    
   
}
