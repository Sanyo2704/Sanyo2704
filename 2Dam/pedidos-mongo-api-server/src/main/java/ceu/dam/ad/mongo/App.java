package ceu.dam.ad.mongo;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.services.ClienteServiceImpl;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;
import ceu.dam.ad.mongo.services.PedidoServiceImpl;

@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		PedidoServiceImpl pService = context.getBean(PedidoServiceImpl.class);
		ClienteServiceImpl cService = context.getBean(ClienteServiceImpl.class);
		
		Cliente cliente = new Cliente();
		cliente.setDni("48231371D");
		cliente.setNombre("Juanlu");
		cliente.setDireccion("C/Almendra");
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setNumero(3);
		pedido.setFecha(LocalDate.now());
		pedido.setDetalles(new ArrayList<>());
		pedido.getDetalles().add(new PedidoDetalle());
		try {
//			cService.crearCliente(cliente);
//			cService.consultarClienteById("67a62a92a7b0bd41e45aacf4");
//			cService.consultarClienteByDni("48231371C");
//			cliente.setDireccion("C/Almendron");
//			cService.actualizarCliente(cliente);
			
			//pService.registrarPedido(pedido);
			pService.consultarPedido("67a62e5e2286e43c11c105af");
			pService.buscarPedidos(LocalDate.now().minusMonths(1), LocalDate.now()).forEach(System.out::println);
			pService.consultarPedidosCliente("48231371A").forEach(System.out::println);
			pService.añadirDetalle("67a62e5e2286e43c11c105af", new PedidoDetalle());
		} catch (DatosIncorrectosException e) {
			e.printStackTrace();
		}
	}

}
