package ceu.dam.ad.mongo.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateClientRequest {
	@NotBlank
	private String dni;
	@NotBlank
	private String nombre;
	@NotBlank
	private String direccion;
}
