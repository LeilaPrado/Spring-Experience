package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
//ler todos os métodos
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello . Java Dev";
    }
}