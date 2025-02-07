package ceu.dam.ad.mongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.repositories.pedido.PedidoRepository;
@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository repo;

	@Override
	public String registrarPedido(Pedido pedido) throws DatosIncorrectosException  {
		if (repo.existsByNumero(pedido.getNumero())) {
			throw new DatosIncorrectosException("Ya existe un pedido con ese id.");
		}
		Pedido pedidoRegistrado = repo.save(pedido);
		return pedidoRegistrado.getId();
	}

	@Override
	public Pedido consultarPedido(String id) throws DatosIncorrectosException {
		Optional<Pedido> pedido = repo.findById(id);
		if (!pedido.isPresent()) {
			throw new DatosIncorrectosException("No existe pedido con ese id.");
		}
		return pedido.get();
	}

	@Override
	public List<Pedido> buscarPedidos(LocalDate desde, LocalDate hasta) {
		return repo.findByFechaBetween(desde, hasta);
	}

	@Override
	public List<Pedido> consultarPedidosCliente(String dni) {
		return repo.buscarPedidosPorDniCliente(dni);
	}

	@Override
	public Pedido añadirDetalle(String id, PedidoDetalle detalle) throws DatosIncorrectosException {
		Pedido pedidoConsultado = consultarPedido(id);
		pedidoConsultado.getDetalles().add(detalle);
		return repo.save(pedidoConsultado);
	}

}
