package tema1.ejercicio2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tema1.ejercicio2.modelo.Cliente;


public class ClienteDao {
	public List<Cliente> listaClientes(Connection conn) throws SQLException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from customer";
		try(Statement stmt = conn.createStatement()){
            //Ejecutar la consulta y obtener el resultado
            ResultSet rs = stmt.executeQuery(sql);
            
            //Procesar los resultados
            while (rs.next()) {
            	Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("customer_id"));
                cliente.setFirstName(rs.getString("first_name"));
                cliente.setLastName(rs.getString("last_name"));
                cliente.setEmail(rs.getString("email"));
                cliente.setActivo(rs.getBoolean("active"));
                clientes.add(cliente);
            }
            return clientes;
		}
	
	}
}
