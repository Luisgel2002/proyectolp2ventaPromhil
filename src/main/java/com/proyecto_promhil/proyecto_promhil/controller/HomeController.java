package com.proyecto_promhil.proyecto_promhil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() { return "redirect:/categorias"; } // o "redirect:/productos"
}
