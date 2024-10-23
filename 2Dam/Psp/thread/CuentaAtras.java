package tema1.thread;

public class CuentaAtras extends Thread{
	private int valorMaximo;
	private int valor;
	private String nombre;
	private static int milis = 300;
	

	public CuentaAtras(int valorMaximo ,String nombre) {
		this.nombre = nombre;
		this.valorMaximo = valorMaximo;
	}

	public static void main(String[] args) {
		CuentaAtras c1 = new CuentaAtras(10,"H-5");
		CuentaAtras c2 = new CuentaAtras(5,"H-3");
		c1.start();
		c2.start();
	}
	
	@Override
	public void run() {
		for( valor = valorMaximo; valor >= 0; valor-- ) {
			System.out.println(this);
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "CuentaAtras [valorMaximo=" + valorMaximo + ", nombre=" + nombre + ", valorActual = "+ valor + "]";
	}

}
