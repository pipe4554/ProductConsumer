package practica2;

public class Consumidor extends Thread {
	public int id;
	public int numVueltas;
	private ColaDeTareas cola;

	public Consumidor(int vueltas, ColaDeTareas Cola) {
		this.numVueltas = vueltas;
		this.cola = Cola;
	}

	public void run() {
        int i = 0;
        while (i < numVueltas) {
             if (cola.quitarTarea()) {
                i++;
            } 
        }
    }
}
