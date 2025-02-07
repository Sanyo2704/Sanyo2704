package ceu.dam.ad.mongo.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.mongo.api.request.CreateClientRequest;
import ceu.dam.ad.mongo.api.request.UpdateClientRequest;
import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.services.ClienteServiceImpl;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(name = "/cliente")
@SecurityRequirement(name = "Authorization")
public class ClienteServiceApi {
	
	@Autowired
	private ClienteServiceImpl service;
	
	@PostMapping
	@Operation(summary = "Crear cliente", description = "Crea un nuevo cliente en el sistema generando automáticamente el ID")
	public Cliente createClient(@RequestBody @Valid CreateClientRequest request) throws DatosIncorrectosException {
		Cliente cliente = new Cliente();
		ModelMapper mapper = new ModelMapper();
		mapper.map(request, cliente);
		return service.crearCliente(cliente);
	}
	
	@PutMapping
	@Operation(summary = "Actualizar cliente", description = "Actualiza un cliente y sus datos")
	public Cliente updateClient(@RequestBody @Valid UpdateClientRequest request) throws DatosIncorrectosException {
		Cliente cliente = new Cliente();
		ModelMapper mapper = new ModelMapper();
		mapper.map(request, cliente);
		return service.actualizarCliente(cliente);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Buscar cliente", description = "Consultar un cliente a partir de su id")
	public Cliente getClientById(@PathVariable String id) throws DatosIncorrectosException {
		return service.consultarClienteById(id);
	}
	
	@GetMapping
	@Operation(summary = "Buscar cliente", description = "Consultar un cliente a partir de su id")
	public Cliente getClientByDni(@RequestParam(defaultValue = "", required = false) String dni) throws DatosIncorrectosException {
		return service.consultarClienteById(dni);
	}

}
