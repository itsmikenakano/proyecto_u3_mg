package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class ConsultorioParalelo extends Thread {

	private DoctorParalelo doctor;

	public ConsultorioParalelo(DoctorParalelo doctor) {
		this.doctor = doctor;
	}

	// Disparar el metodo a paralelizar
	@Override
	public void run() {
		this.atender(this.doctor);
	}

	public void atender(DoctorParalelo doctor) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando doctor: " + doctor);
		for (String paciente : doctor.getPacientes()) {
			this.atenderPaciente(paciente);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("Terminó: " + doctor.getNombre() + " en: " + tiempoTranscurrido + "segs");

	}

	private void atenderPaciente(String paciente) {
		System.out.println("Atendiendo a: " + paciente);
		// Demorar el metodo 3 segs
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
