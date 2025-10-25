package com.proyecto_promhil.proyecto_promhil.controller;

import com.proyecto_promhil.proyecto_promhil.model.Producto;
import com.proyecto_promhil.proyecto_promhil.model.Categoria;
import com.proyecto_promhil.proyecto_promhil.repository.ProductoRepository;
import com.proyecto_promhil.proyecto_promhil.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @GetMapping
    public String listar(@RequestParam(required = false) Integer categoriaId, Model model) {
        model.addAttribute("categorias", categoriaRepository.findByEstadoTrue());
        if (categoriaId != null) {
            model.addAttribute("categoriaId", categoriaId);
            model.addAttribute("productos",
                    productoRepository.findByCategoria_IdCategoriaAndEstadoTrue(categoriaId));
        } else {
            model.addAttribute("productos", productoRepository.findByEstadoTrue());
        }
        return "productos/productos";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findByEstadoTrue());
        return "productos/form";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Integer id, Model model) {
        var producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaRepository.findByEstadoTrue());
        return "productos/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("producto") Producto producto,
                          @RequestParam Integer idCategoria) {
        var cat = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + idCategoria));
        producto.setCategoria(cat);
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Integer id, RedirectAttributes ra) {
        var p = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        p.setEstado(false);
        productoRepository.save(p);
        ra.addFlashAttribute("ok", "Producto desactivado.");
        return "redirect:/productos";
    }
}
