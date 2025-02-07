package ceu.dam.ad.mongo.repositories.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import ceu.dam.ad.mongo.model.Pedido;

public class CustomPedidoRepositoryImpl implements CustomPedidoRepository{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Pedido> buscarPedidosPorDniCliente(String dni) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cliente.dni").is(dni));
		return mongoTemplate.find(query, Pedido.class);
	}

}
