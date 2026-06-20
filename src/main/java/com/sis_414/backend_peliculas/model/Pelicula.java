package com.sis_414.backend_peliculas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String titulo;

	@Column(nullable = false, length = 120)
	private String director;

	@Column(nullable = false)
	private Integer anioLanzamiento;

	@Column(nullable = false, length = 80)
	private String genero;

	@Column(nullable = false, length = 1000)
	private String sinopsis;

	public Pelicula() {
	}

	public Pelicula(Long id, String titulo, String director, Integer anioLanzamiento, String genero, String sinopsis) {
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.anioLanzamiento = anioLanzamiento;
		this.genero = genero;
		this.sinopsis = sinopsis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getAnioLanzamiento() {
		return anioLanzamiento;
	}

	public void setAnioLanzamiento(Integer anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
}
