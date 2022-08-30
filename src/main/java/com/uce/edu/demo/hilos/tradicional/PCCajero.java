package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCCajero {
	public void procesar(Cajero cajero) {
		System.out.println("Procesando cajero: " + cajero);
		for(String cliente: cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		//Demorar el metodo 10 seg
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
