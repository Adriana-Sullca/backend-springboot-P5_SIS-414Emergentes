package com.sis_414.backend_peliculas.controller;

import com.sis_414.backend_peliculas.model.Pelicula;
import com.sis_414.backend_peliculas.service.PeliculaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@Tag(name = "Peliculas", description = "Endpoints para gestionar peliculas")
public class PeliculaController {

	private final PeliculaService peliculaService;

	public PeliculaController(PeliculaService peliculaService) {
		this.peliculaService = peliculaService;
	}

	@GetMapping
	@Operation(summary = "Listar peliculas")
	public ResponseEntity<List<Pelicula>> listarPeliculas() {
		return ResponseEntity.ok(peliculaService.listarPeliculas());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener una pelicula por id")
	public ResponseEntity<Pelicula> obtenerPeliculaPorId(@PathVariable Long id) {
		return peliculaService.obtenerPeliculaPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@Operation(summary = "Crear una pelicula")
	public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula pelicula) {
		return ResponseEntity.status(HttpStatus.CREATED).body(peliculaService.crearPelicula(pelicula));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Actualizar una pelicula")
	public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
		return peliculaService.actualizarPelicula(id, pelicula)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar una pelicula")
	public ResponseEntity<Void> eliminarPelicula(@PathVariable Long id) {
		if (!peliculaService.eliminarPelicula(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
