package practica2;

import java.util.ArrayList;


public class App {

	public static void main(String[] args) {

		ArrayList<Integer> numMaximo = new ArrayList<Integer>();
		ColaDeTareas colaMain = new ColaDeTareas(numMaximo);
		Productor prod = new Productor(10, colaMain);
		Consumidor cons = new Consumidor(10, colaMain);
		

		ArrayList<Thread> threads = new ArrayList<Thread>();

		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(prod));
		}

		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(cons));
		}

		for (Thread t : threads) {
			t.start();

		}
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println("NO SE HAN FINALIZADO LOS HILOS");
				e.printStackTrace();
			}
		}

	}
}
