package ceu.dam.ad.mongo.services;

import ceu.dam.ad.mongo.model.Cliente;

public interface ClienteService {

	/** Debe guardar el cliente en Mongo. Si ya hay un cliente con ese DNI, lanzará DatosIncorrectosException
	 * Ninguno de los datos del cliente pueden ser blank
	 * 
	 * Luego, usando otra clase, publica este método en un API con método /cliente POST. Si se lanza excepción de validación o 
	 * DatosIncorrectosException se debe devolver un BadRequest con mensaje explicativo
	 * 
	 * @param cliente
	 * @return
	 * @throws DatosIncorrectosException
	 */
	public Cliente crearCliente(Cliente cliente) throws DatosIncorrectosException;
	
	
	/** Actualiza los datos del cliente recibido. Si el cliente recibido no tiene ID, lo buscamos por DNI para
	 * actualizarlo. Si no existe el cliente recibido, lanzará DatosIncorrectosException
	 * Ninguno de los datos del cliente puede ser blank
	 * 
	 * Luego, usando otra clase, publica este método en un API con método /cliente PUT. Si se lanza excepción de validación o 
	 * DatosIncorrectosException se debe devolver un BadRequest con mensaje explicativo
	 * 
	 * @param cliente
	 * @return
	 * @throws DatosIncorrectosException
	 */
	public Cliente actualizarCliente(Cliente cliente) throws DatosIncorrectosException;
	
	
	/** Devuelve el cliente con el ID indicado. 
	 * Si no existe, lanzará DatosIncorrectosException
	 * 
	 * Luego, usando otra clase, publica este método en un API con método /cliente GET que reciba el ID en la URL como path.
	 * Si se lanza DatosIncorrectosException se debe devolver un BadRequest con mensaje explicativo
	 * 
	 * @param id
	 * @return
	 * @throws DatosIncorrectosException
	 */
	public Cliente consultarClienteById(String id) throws DatosIncorrectosException;
	
	
	/** Devuelve el cliente con el DNI indicado. 
	 * Si no existe, lanzará DatosIncorrectosException
	 * 
	 * Luego, usando otra clase, publica este método en un API con método /cliente/dni/ GET que reciba el DNI en la URL como path.
	 * Si se lanza DatosIncorrectosException se debe devolver un BadRequest con mensaje explicativo
	 * 
	 * @param id
	 * @return
	 * @throws DatosIncorrectosException
	 */
	public Cliente consultarClienteByDni(String dni) throws DatosIncorrectosException;

}
