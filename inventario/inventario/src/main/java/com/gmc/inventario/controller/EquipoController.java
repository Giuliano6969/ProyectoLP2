package com.gmc.inventario.controller;

import com.gmc.inventario.model.Equipo;
import com.gmc.inventario.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping("/")
    public String index() {
        return "index"; // Página de inicio
    }

    @GetMapping
    public String getAllEquipos(Model model) {
        List<Equipo> equipos = equipoService.findAll();
        model.addAttribute("equipos", equipos);
        return "listar_equipos"; // Página de lista de equipos
    }

    @GetMapping("/{serial}")
    public String getEquipoById(@PathVariable String serial, Model model) {
        Equipo equipo = equipoService.findById(serial).orElse(null);
        model.addAttribute("equipo", equipo);
        return "detalle_equipos"; // Página de detalles
    }

    @GetMapping("/nuevo")
    public String nuevoEquipoForm(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "nuevo_equipo"; // Formulario de nuevo equipo
    }

    @PostMapping
    public String saveEquipo(@ModelAttribute Equipo equipo) {
        equipoService.save(equipo);
        return "redirect:/equipos"; // Redirige a lista después de guardar
    }

    @DeleteMapping("/{serial}")
    public String deleteEquipo(@PathVariable String serial) {
        equipoService.deleteById(serial); // Llama al servicio para eliminar por serial
        return "redirect:/equipos"; // Redirige a la lista de equipos después de eliminar
    }
}
