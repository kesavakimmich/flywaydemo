package com.example.flywaydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AttributesController {

    @GetMapping
    public String getAttributes() {
        return "Hello World";
    }
}
