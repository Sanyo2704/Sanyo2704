package ceu.dam.ad.mongo.services;

import java.time.LocalDate;
import java.util.List;

import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;

public interface PedidoService {
	
	/** Creará el pedido recibido en mongoDB. Si ya existe un pedido con ese número, lanzará DatosIncorrectosException.
	 * El pedido no puede tener ningun dato en blanco ni null. Al menos tendrá que tener un detalle. Y la cantidad de cada 
	 * detalle será de al menos 1
	 * 
	 * Luego, usando otra clase, publica este método en un API con método /pedido POST. Si se lanza excepción de validación o 
	 * DatosIncorrectosException se debe devolver un BadRequest con mensaje explicativo
	 * 
	 * @param pedido
	 * @return
	 * @throws DatosIncorrectosException
	 */
	public String registrarPedido(Pedido pedido) throws DatosIncorrectosException;
	
	
	
	/** Consultará y devolverá el pedido con ID indicado por parámetro. Si no existe el pedido, lanzará DatosIncorrectosException
	 *
	 * Luego, usando otra clase, publica este método en un API con método /pedido GET que reciba el ID dentro de la URL como path.
	 * Si se lanza excepción DatosIncorrectosException se debe devolver un BadRequest con mensaje explicativo
	 *
	 * @param pedido
	 * @return
	 * @throws DatosIncorrectosException
	 */
	public Pedido consultarPedido(String id) throws DatosIncorrectosException;
	
	
	
	/** Devolverá lista de pedidos comprendidos entre las fechas indicadas (ambas inclusive). 
	 * 
	 * Luego, usando otra clase, publica este método en un API con método /pedidos GET que reciba los filtros por URL como 
	 * parámetros. Si no se indica fecha desde se usará la fecha de hace justo un mes. Si no se recibe fecha hasta se usará el día de hoy
	 * Las fechas, si vienen,  se deben recibir en formato dd-MM-yyyy
	 * 
	 * @param pedido
	 * @return
	 */
	public List<Pedido> buscarPedidos(LocalDate desde, LocalDate hasta);
	
	
	/** Devolverá lista de pedidos del cliente con el DNI indicado
	 * 
	 * Luego, usando otra clase, publica este método en un API con método /pedidos/cliente GET que reciba el DNI dentro 
	 * de la URL como path. 
	 * 
	 * @param pedido
	 * @return
	 */
	public List<Pedido> consultarPedidosCliente(String dni);
	
	
	/** Añadirá al pedido del ID indicado el detalle que se pasa por parámetro. Si el pedido no existe,
	 * lanzará DatosIncorrectosException. 
	 * Ningún dato del detalle podrá ser blanco o nulo. La cantidad tendrá que ser 1 o mayor. 
	 * 
	 * Luego, usando otra clase, publica este método en un API con método /pedido PUT. Recibirá el ID como path en el URL
	 * y el detallle nuevo del pedido en el body. Si se lanza excepción de validación o  DatosIncorrectosException se debe
	 *  devolver un BadRequest con mensaje explicativo
	 * 
	 * @param pedido
	 * @return
	 * @throws DatosIncorrectosException
	 */
	public Pedido añadirDetalle(String id, PedidoDetalle detalle) throws DatosIncorrectosException;
	
}
