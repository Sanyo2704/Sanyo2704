package ceu.dam.ad.mongo.repositories.pedido;

import java.util.List;

import ceu.dam.ad.mongo.model.Pedido;

public interface CustomPedidoRepository {
	public List<Pedido> buscarPedidosPorDniCliente(String dni);
}
