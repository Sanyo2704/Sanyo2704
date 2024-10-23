package tema1.ejercicios.luciernaga;

public class Luciernaga {
	private String nombre;
	private Boolean encendido;
	private int energia;
	private static long milis = 300;
	
	
	
	public Luciernaga(String nombre, int energia) {
		super();
		this.nombre = nombre;
		if (energia >= 1 && energia <= 50) {
			this.energia = energia;
		}
		this.encendido = false;
	}

	public void enciende() {
		if (energia != 0 && !encendido) {
			encendido = true;
		}
		while (energia > 0) {
			energia--;
			System.out.println(nombre + " Actualizada");
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		encendido = false;
	}

	public static void main(String[] args) {
		Luciernaga l1 = new Luciernaga("L1", 10);
		l1.enciende();
		Luciernaga l2 = new Luciernaga("L2", 8);
		l2.enciende();
		Luciernaga l3 = new Luciernaga("L3", 5);
		l3.enciende();
	}

}
