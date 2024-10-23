package tema1.synchr0nized;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Synchr0nized implements Runnable{
	
	private String nombre;
	private static Integer milis = 100;
	private static long ejecuciones= 0;
	private long ejecucionesInstancia= 0;
	
	public Synchr0nized(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	private synchronized void incrementarEjecuciones() {
        ejecuciones++; // Modificación de variable estática (compartida)
        ejecucionesInstancia++; // Modificación de la instancia particular
    }

	@Override
	public synchronized void run() {
		//Guardamos la hora actual
		LocalDateTime hActual = LocalDateTime.now();
		//Creamos el formato
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		//Mostramos la línea
		System.out.println("Lanzando bola desde " + nombre + " a las " + hActual.format(formato));
		incrementarEjecuciones();
	}

	public static void main(String[] args) {
		
		  Synchr0nized c1 = new Synchr0nized("C1");
		
		  ExecutorService executor1 = Executors.newFixedThreadPool(3);
	      
		  for (int i = 0; i < 50; i++) {
	            new Thread(c1).start();
	        }

		  
	      Synchr0nized Lanzador1 = new Synchr0nized("Lanzabolas1");
	      Synchr0nized Lanzador2 = new Synchr0nized("Lanzabolas2");
	      Synchr0nized Lanzador3 = new Synchr0nized("Lanzabolas3");
	      
	      executor1.execute(Lanzador1);
	      executor1.execute(Lanzador2);
	      executor1.execute(Lanzador3);
	      
	      try {
	            Thread.sleep(milis);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	      
	      System.out.println(ejecuciones);
	      System.out.println(c1.ejecucionesInstancia);
	      
	}
}