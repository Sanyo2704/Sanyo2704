package ceu.dam.ad.mongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.repositories.cliente.ClienteRepository;
@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public Cliente crearCliente(Cliente cliente) throws DatosIncorrectosException {
		Optional<Cliente> clienteConsultado = repo.findOneByDni(cliente.getDni());
		if (clienteConsultado.isPresent()) {
			throw new DatosIncorrectosException("Ya existe cliente con dicho dni");
		}
		return repo.save(cliente);
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) throws DatosIncorrectosException {
		if (cliente.getId()==null) {
			Optional<Cliente> clienteConsultado = repo.findOneByDni(cliente.getDni());
			if (!clienteConsultado.isPresent()) {
				throw new DatosIncorrectosException("No existe cliente con dicho dni");
			} else {
				cliente.setId(clienteConsultado.get().getId());
			}
		}
		return repo.save(cliente);
	}

	@Override
	public Cliente consultarClienteById(String id) throws DatosIncorrectosException {
		Optional<Cliente> clienteConsultado = repo.findById(id);
		if (!clienteConsultado.isPresent()) {
			throw new DatosIncorrectosException("No existe cliente con dicho id");
		}
		return clienteConsultado.get();
	}

	@Override
	public Cliente consultarClienteByDni(String dni) throws DatosIncorrectosException {
		Optional<Cliente> clienteConsultado = repo.findOneByDni(dni);
		if (!clienteConsultado.isPresent()) {
			throw new DatosIncorrectosException("No existe cliente con dicho dni");
		}
		return clienteConsultado.get();
	}

}
