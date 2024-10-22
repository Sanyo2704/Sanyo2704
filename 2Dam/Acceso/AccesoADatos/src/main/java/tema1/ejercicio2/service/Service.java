package tema1.ejercicio2.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Service {
	public void testConexion() {
		Connection conn = abrirConexion();
		System.out.println("Esta es mi conexión: " + conn);
		if (conn != null) {
			System.out.println("Todo OK!!");
		}
		else {
			System.out.println("Esto no rula...");
		}
	}
	
	
	protected Connection abrirConexion() {
		String urlConexion =  "jdbc:mariadb://localhost:3306/sakila";
		String driver = "org.mariadb.jdbc.Driver";
		String usuario = "sakila";
		String password = "123456";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(urlConexion, usuario, password);
			return conn;
		}
		catch(Exception e) {
			System.err.println("No he podido abrir la conexión. " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("No puedo conectarme a la BBDD");
		}
		
	}
}
