package com.vetnova.valoracionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetnova.valoracionservice.model.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {

    List<Valoracion> findByUsuarioId(Long usuarioId);

    List<Valoracion> findByServicioId(Long servicioId);
}