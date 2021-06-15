package practica2;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class ColaDeTareas {

	ArrayList<Integer> numeros = new ArrayList<Integer>(10);

	public ColaDeTareas(ArrayList<Integer> numeros) {
		super();
		this.numeros = numeros;
	}

	public synchronized boolean añadirTarea() {
		if (numeros.size() == 10) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		int numero = ThreadLocalRandom.current().nextInt(0, 11);
		numeros.add(numero);
		System.out.println("Productor " + Thread.currentThread().getId() + " produce el numero--> " + numero);
		notify();
		return true;

	}

	public synchronized boolean quitarTarea() {

		if (!numeros.isEmpty()) {

			int dato = numeros.remove(numeros.size() - 1);

			System.out.println("Consumidor " + Thread.currentThread().getId() + " consume el numero--> " + dato);

			notify();
			return true;

		}

		return false;

	}

	public void mostrar() {
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));

		}
	}
}
