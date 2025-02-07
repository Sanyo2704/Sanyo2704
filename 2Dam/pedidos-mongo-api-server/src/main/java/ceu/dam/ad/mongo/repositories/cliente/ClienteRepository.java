package ceu.dam.ad.mongo.repositories.cliente;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.mongo.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{
	public Optional<Cliente> findOneByDni(String dni);
}
