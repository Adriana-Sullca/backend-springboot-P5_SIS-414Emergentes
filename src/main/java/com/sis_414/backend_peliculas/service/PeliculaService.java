package com.sis_414.backend_peliculas.service;

import com.sis_414.backend_peliculas.model.Pelicula;
import com.sis_414.backend_peliculas.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

	private final PeliculaRepository peliculaRepository;

	public PeliculaService(PeliculaRepository peliculaRepository) {
		this.peliculaRepository = peliculaRepository;
	}

	public List<Pelicula> listarPeliculas() {
		return peliculaRepository.findAll();
	}

	public Optional<Pelicula> obtenerPeliculaPorId(Long id) {
		return peliculaRepository.findById(id);
	}

	public Pelicula crearPelicula(Pelicula pelicula) {
		pelicula.setId(null);
		return peliculaRepository.save(pelicula);
	}

	public Optional<Pelicula> actualizarPelicula(Long id, Pelicula peliculaActualizada) {
		return peliculaRepository.findById(id)
				.map(pelicula -> {
					pelicula.setTitulo(peliculaActualizada.getTitulo());
					pelicula.setDirector(peliculaActualizada.getDirector());
					pelicula.setAnioLanzamiento(peliculaActualizada.getAnioLanzamiento());
					pelicula.setGenero(peliculaActualizada.getGenero());
					pelicula.setSinopsis(peliculaActualizada.getSinopsis());
					return peliculaRepository.save(pelicula);
				});
	}

	public boolean eliminarPelicula(Long id) {
		if (!peliculaRepository.existsById(id)) {
			return false;
		}
		peliculaRepository.deleteById(id);
		return true;
	}
}
