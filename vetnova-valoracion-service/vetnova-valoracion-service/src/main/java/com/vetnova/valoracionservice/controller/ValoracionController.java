package com.vetnova.valoracionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vetnova.valoracionservice.model.Valoracion;
import com.vetnova.valoracionservice.service.ValoracionService;

@RestController
@RequestMapping("/api/valoraciones")
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;

    @GetMapping
    public List<Valoracion> obtenerValoraciones() {
        return valoracionService.obtenerValoraciones();
    }

    @GetMapping("/{id}")
    public Valoracion obtenerValoracionPorId(@PathVariable Long id) {
        return valoracionService.obtenerValoracionPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Valoracion> obtenerValoracionesPorUsuario(@PathVariable Long usuarioId) {
        return valoracionService.obtenerValoracionesPorUsuario(usuarioId);
    }

    @GetMapping("/servicio/{servicioId}")
    public List<Valoracion> obtenerValoracionesPorServicio(@PathVariable Long servicioId) {
        return valoracionService.obtenerValoracionesPorServicio(servicioId);
    }

    @PostMapping
    public Valoracion guardarValoracion(@RequestBody Valoracion valoracion) {
        return valoracionService.guardarValoracion(valoracion);
    }

    @PutMapping("/{id}")
    public Valoracion actualizarValoracion(@PathVariable Long id,
                                           @RequestBody Valoracion valoracion) {
        return valoracionService.actualizarValoracion(id, valoracion);
    }

    @DeleteMapping("/{id}")
    public String eliminarValoracion(@PathVariable Long id) {
        boolean eliminado = valoracionService.eliminarValoracion(id);

        if (eliminado) {
            return "Valoración eliminada correctamente";
        }

        return "Valoración no encontrada";
    }
}