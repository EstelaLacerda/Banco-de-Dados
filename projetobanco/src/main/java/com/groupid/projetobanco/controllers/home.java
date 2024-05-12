package com.groupid.projetobanco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class home {

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

}