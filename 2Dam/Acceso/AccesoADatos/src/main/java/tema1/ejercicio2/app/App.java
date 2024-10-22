package tema1.ejercicio2.app;

import tema1.ejercicio2.service.ClienteService;
import tema1.ejercicio2.service.ClienteServiceException;

public class App {
	public static void main(String[] args) throws ClienteServiceException {
		ClienteService service = new ClienteService();
		System.out.println(service.consultarClientes());
	}
}
