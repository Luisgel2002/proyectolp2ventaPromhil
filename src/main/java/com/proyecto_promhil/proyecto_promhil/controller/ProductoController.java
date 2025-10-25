package com.proyecto_promhil.proyecto_promhil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.proyecto_promhil.proyecto_promhil.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoRepository productoRepository;

    @GetMapping("/productos")
    public String listar(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return "productos";
    }
}
