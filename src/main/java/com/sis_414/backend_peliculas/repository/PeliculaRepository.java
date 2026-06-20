package com.sis_414.backend_peliculas.repository;

import com.sis_414.backend_peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
