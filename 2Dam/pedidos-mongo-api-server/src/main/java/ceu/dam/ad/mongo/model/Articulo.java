package ceu.dam.ad.mongo.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulo {

	private String codigo;
	private String descripcion;
	private BigDecimal precio;
	
}
	
