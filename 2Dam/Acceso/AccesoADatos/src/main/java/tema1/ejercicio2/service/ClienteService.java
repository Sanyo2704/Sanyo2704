package tema1.ejercicio2.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tema1.ejercicio2.dao.ClienteDao;
import tema1.ejercicio2.modelo.Cliente;

public class ClienteService extends Service{
	
	private static final Logger log = LoggerFactory.getLogger(ClienteService.class);
	private ClienteDao dao;
	
	public ClienteService() {
		dao = new ClienteDao();
	}
	
	public Map<String, Cliente> consultarClientes() throws ClienteServiceException {
		log.debug("Consultando clientes: ");
		try {
			log.info("Recogiendo clientes de la base de datos..");
			List<Cliente> clientes = dao.listaClientes(abrirConexion());
			Map<String, Cliente> mapaCli = clientes.stream()
					.collect(Collectors.toMap(e -> e.getEmail(), c -> c));
			log.info("Consulta de clientes realizada");
			return mapaCli;
		} catch (SQLException e) {
			log.error("Error consultando los clientes", e);
			e.printStackTrace();
			throw new ClienteServiceException("Error: " + e.getMessage(), e);
		}
		
		
		
		
		
	}
}
