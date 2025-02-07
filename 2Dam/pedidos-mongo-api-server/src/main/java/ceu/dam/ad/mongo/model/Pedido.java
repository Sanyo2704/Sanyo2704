package ceu.dam.ad.mongo.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pedidos")
public class Pedido {
	
	@Id
	@Schema(description = "Identificador autogenerado del pedido.")
	private String id;
	@NotNull(message = "El cliente debe existir.")
	private Cliente cliente;
	@NotBlank(message = "La fecha es obligatoria.")
	private LocalDate fecha;
	@NotBlank(message = "El numero es obligatorio.")
	private Integer numero;
	@Size(min = 1, message = "Es obligatorio indicar al menos un detalle.")
	private List<PedidoDetalle> detalles;
	
}
