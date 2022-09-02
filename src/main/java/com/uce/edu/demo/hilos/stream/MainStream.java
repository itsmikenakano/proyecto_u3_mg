package com.uce.edu.demo.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		List<Integer> listaNumerosAlumnos = new ArrayList<>();
		for (int i = 1; i < 5000; i++) {
			listaNumerosAlumnos.add(i);
		}

		List<String> listaProcesada = listaNumerosAlumnos.stream().map(numero -> convertirIdAlumno(numero))
				.collect(Collectors.toList());

		listaProcesada.forEach(cadena -> System.out.println(cadena));

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "segs");

	}

	private static String convertirIdAlumno(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
			// SUMAS
			// RESTAS
			// DIVI
			// MULTI
			// INSERT
			// CONSULTAS
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ID: " + id.toString();

	}

}
