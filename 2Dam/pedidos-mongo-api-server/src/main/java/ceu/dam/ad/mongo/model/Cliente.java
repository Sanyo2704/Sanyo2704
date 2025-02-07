package ceu.dam.ad.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
public class Cliente {
	
	@Id
	@Schema(description = "Identificador autogenerado del cliente")
	private String id;
	@NotBlank(message = "El dni es obligatorio")
	private String dni;
	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	@NotBlank(message = "La dirección es obligatoria")
	private String direccion;
	
	
}
