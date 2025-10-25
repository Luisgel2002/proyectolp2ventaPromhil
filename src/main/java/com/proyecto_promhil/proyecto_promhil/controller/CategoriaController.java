package com.proyecto_promhil.proyecto_promhil.controller;

import com.proyecto_promhil.proyecto_promhil.model.Categoria;
import com.proyecto_promhil.proyecto_promhil.repository.CategoriaRepository;
import com.proyecto_promhil.proyecto_promhil.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaRepository.findByEstadoTrue());
        return "categorias/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Integer id, Model model) {
        var categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + id));
        model.addAttribute("categoria", categoria);
        return "categorias/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("categoria") Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Integer id, RedirectAttributes ra) {
        var cat = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
        long usados = productoRepository.countByCategoria_IdCategoria(id);
        if (usados > 0) {
            ra.addFlashAttribute("error", "No se puede eliminar: la categoría tiene productos asociados.");
            return "redirect:/categorias";
        }
        cat.setEstado(false);
        categoriaRepository.save(cat);
        ra.addFlashAttribute("ok", "Categoría desactivada.");
        return "redirect:/categorias";
    }
}
