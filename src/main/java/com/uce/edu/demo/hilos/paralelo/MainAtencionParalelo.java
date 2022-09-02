package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainAtencionParalelo {

	public static void main(String[] args) {
		
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		DoctorParalelo doctor1 = new DoctorParalelo("Chloe", Arrays.asList("Pepito","Pepe"));
		DoctorParalelo doctor2 = new DoctorParalelo("Xavier", Arrays.asList("Joana"));
		DoctorParalelo doctor3 = new DoctorParalelo("Santiago", Arrays.asList("Steve","Carlos","Olivia"));
		DoctorParalelo doctor4 = new DoctorParalelo("Michael", Arrays.asList("Josue"));
		DoctorParalelo doctor5 = new DoctorParalelo("Luis", Arrays.asList("Jonas"));

		ConsultorioParalelo gestorAtencion = new ConsultorioParalelo(doctor1);
		gestorAtencion.start();// atender

		ConsultorioParalelo gestorAtencion2 = new ConsultorioParalelo(doctor2);
		gestorAtencion2.start();//atender

		ConsultorioParalelo gestorAtencion3 = new ConsultorioParalelo(doctor3);
		gestorAtencion3.start();//atender

		ConsultorioParalelo gestorAtencion4 = new ConsultorioParalelo(doctor4);
		gestorAtencion4.start();//atender

		ConsultorioParalelo gestorAtencion5 = new ConsultorioParalelo(doctor5);
		gestorAtencion5.start();//atender

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "segs");

	}

}
