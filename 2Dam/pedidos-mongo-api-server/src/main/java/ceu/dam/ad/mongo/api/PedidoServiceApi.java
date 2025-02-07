package ceu.dam.ad.mongo.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;
import ceu.dam.ad.mongo.services.PedidoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Authorization")
public class PedidoServiceApi {

	@Autowired
	private PedidoServiceImpl service;

	@PostMapping("/pedido")
	@Operation(summary = "Crear pedido", description = "Crea un nuevo pedido en el sistema generando automáticamente el ID")
	public String createPedido(@RequestBody @Valid Pedido request) throws DatosIncorrectosException {
		return service.registrarPedido(request);
	}

	@GetMapping("/pedido/{id}")
	@Operation(summary = "Buscar pedido", description = "Consultar un pedido a partir de su id")
	public Pedido getPedidoById(@PathVariable String id) throws DatosIncorrectosException {
		return service.consultarPedido(id);
	}

	@GetMapping("/pedidos")
	@Operation(summary = "Buscar pedido por fechas", description = "Consultar un pedido a partir de 2 fechas")
	public List<Pedido> getPedidoByDates(
			@DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam(defaultValue = "", required = false) LocalDate desde,
			@DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam(defaultValue = "", required = false) LocalDate hasta) {
		if (desde == null) {
			desde = LocalDate.now().minusMonths(1);
		}
		if (hasta == null) {
			hasta = LocalDate.now();
		}
		return service.buscarPedidos(desde, hasta);
	}
	
	@GetMapping("/pedidos/cliente")
	@Operation(summary = "Buscar pedidos de un cliente", description = "Consultar los pedido de un cliente")
	public List<Pedido> getPedidosClient(@RequestParam(defaultValue = "", required = false) String dni) {
		return service.consultarPedidosCliente(dni);
	}
	
	@PutMapping("/pedido/{id}")
	public Pedido putMethodName(@PathVariable String id, @RequestBody @Valid PedidoDetalle detalle) throws DatosIncorrectosException {
		return service.añadirDetalle(id, detalle);
	}
	
	
	
}
