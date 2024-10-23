package tema1.runnable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lanzabolas implements Runnable{
	
	private String nombre;
	
	public Lanzabolas(String nombre) {
		super();
		this.nombre = nombre;
	}


	@Override
	public void run() {
		//Guardamos la hora actual
		LocalDateTime hActual = LocalDateTime.now();
		//Creamos el formato
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		//Mostramos la línea
		System.out.println("Lanzando bola desde " + nombre + " a las " + hActual.format(formato));
	}

}
