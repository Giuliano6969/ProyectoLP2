package com.gmc.inventario.service;

import com.gmc.inventario.model.Equipo;
import com.gmc.inventario.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired; // Import correcto
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository; // Inyección de dependencia para el repositorio de equipos

    // Método para obtener todos los equipos
    public List<Equipo> findAll() {
        return equipoRepository.findAll(); // Retornar lista de todos los equipos
    }

    // Método para buscar un equipo por su serial
    public Optional<Equipo> findById(String serial) {
        return equipoRepository.findById(serial); // Retornar el equipo encontrado
    }

    // Método para guardar un nuevo equipo
    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo); // Guardar y retornar el equipo
    }

    // Método para eliminar un equipo por su serial
    public void deleteById(String serial) {
        equipoRepository.deleteById(serial); // Eliminar el equipo por su serial
    }
}
