package com.sis_414.backend_peliculas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI peliculasOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("API de Peliculas")
						.version("1.0.0")
						.description("API REST para la gestion de peliculas"));
	}
}
