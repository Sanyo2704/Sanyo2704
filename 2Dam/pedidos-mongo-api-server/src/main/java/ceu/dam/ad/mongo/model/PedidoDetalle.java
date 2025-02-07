package ceu.dam.ad.mongo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDetalle {
	
	@NotNull(message = "El articulo debe existir.")
	private Articulo articulo;
	@NotBlank(message = "La cantidad es obligatoria.")
	@Min(1)
	private Integer cantidad;
	
}
