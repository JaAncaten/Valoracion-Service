
package com.vetnova.valoracionservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetnova.valoracionservice.model.Valoracion;
import com.vetnova.valoracionservice.repository.ValoracionRepository;

@Service
public class ValoracionService {

    @Autowired
    private ValoracionRepository valoracionRepository;

    public List<Valoracion> obtenerValoraciones() {
        return valoracionRepository.findAll();
    }

    public Valoracion obtenerValoracionPorId(Long id) {
        return valoracionRepository.findById(id).orElse(null);
    }

    public List<Valoracion> obtenerValoracionesPorUsuario(Long usuarioId) {
        return valoracionRepository.findByUsuarioId(usuarioId);
    }

    public List<Valoracion> obtenerValoracionesPorServicio(Long servicioId) {
        return valoracionRepository.findByServicioId(servicioId);
    }

    public Valoracion guardarValoracion(Valoracion valoracion) {
        valoracion.setFecha(LocalDateTime.now());
        return valoracionRepository.save(valoracion);
    }

    public Valoracion actualizarValoracion(Long id, Valoracion valoracionActualizada) {
        Optional<Valoracion> valoracionExistente = valoracionRepository.findById(id);

        if (valoracionExistente.isPresent()) {
            Valoracion valoracion = valoracionExistente.get();

            valoracion.setUsuarioId(valoracionActualizada.getUsuarioId());
            valoracion.setServicioId(valoracionActualizada.getServicioId());
            valoracion.setCalificacion(valoracionActualizada.getCalificacion());
            valoracion.setComentario(valoracionActualizada.getComentario());

            return valoracionRepository.save(valoracion);
        }

        return null;
    }

    public boolean eliminarValoracion(Long id) {
        if (valoracionRepository.existsById(id)) {
            valoracionRepository.deleteById(id);
            return true;
        }

        return false;
    }
}