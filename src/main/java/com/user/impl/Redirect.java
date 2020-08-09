package com.user.impl;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping(path="/view")
public class Redirect {
 
    @RequestMapping(path = "/login")
    public String home() {
    	System.out.println("index2");
        return "login";
    }
     
    @RequestMapping(path = "/register")
    public String register() {
    	System.out.println("index2");
        return "register";
    }
  
 
}

