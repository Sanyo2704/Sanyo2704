package tema1.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run{

	public static void main(String[] args) {
		  ExecutorService executor1 = Executors.newFixedThreadPool(3);
	      ExecutorService executor2 = Executors.newFixedThreadPool(1);
	      ExecutorService executor3 = Executors.newFixedThreadPool(9);
		
		Lanzabolas lanzabolas1 = new Lanzabolas("Lanzador1");
		Lanzabolas lanzabolas2 = new Lanzabolas("Lanzador2");
		Lanzabolas lanzabolas3 = new Lanzabolas("Lanzador3");
		
		//new Thread(lanzabolas1).start();
		//new Thread(lanzabolas2).start();
		//new Thread(lanzabolas3).start();
		
		/*
		System.out.println("Pool fijo de 3 con 3 tareas");
        // Ejecutar las instancias de Lanzabolas usando el ExecutorService1
        executor1.execute(lanzabolas1);
        executor1.execute(lanzabolas2);
        executor1.execute(lanzabolas3);
        */
		
		/*
		System.out.println("Pool fijo de 1 con 9 tareas");
        // Ejecutar las instancias de Lanzabolas usando el ExecutorService2
        for(int i = 0; i < 3; i++) {
	        executor2.execute(lanzabolas1);
	        executor2.execute(lanzabolas2);
	        executor2.execute(lanzabolas3);
        }
        */
        
        
        System.out.println("Pool fijo de 9 con 9 tareas");
        // Ejecutar las instancias de Lanzabolas usando el ExecutorService2
        for(int i = 0; i < 3; i++) {
	        executor3.execute(lanzabolas1);
	        executor3.execute(lanzabolas2);
	        executor3.execute(lanzabolas3);
        }
        
     // Iniciar el proceso de apagado del ExecutorService
        executor1.shutdown();
        executor2.shutdown();
        executor3.shutdown();
	}

}
