package practica2;

public class Productor extends Thread {
	public int id;
	public int numVueltas;
	private ColaDeTareas cola;

	public Productor(int vueltas, ColaDeTareas Cola) {
		this.numVueltas = vueltas;
		this.cola = Cola;
	}

	public void run() {
		int i = 0;
		while (i < numVueltas) {
			cola.añadirTarea();
			i++;
		}

	}

}
