package com.blumbit.gestion.gestiontareas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/state")
public class TestController {

    @GetMapping("")
    public String checkStatus() {
        return "Service Available";
    }
    

}
