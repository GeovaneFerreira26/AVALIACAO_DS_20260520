package com.example.avaliacao20260520.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Welcome {

    @GetMapping("/")
    public String mensagem(){
        return "Bem-Vindo, Geovane!!!";
    }

    @GetMapping("/dev")
    public String devMensagem(){
        return "Desenvolvido por Geovane Ferreira 👨🏾‍💻";
    }

}
