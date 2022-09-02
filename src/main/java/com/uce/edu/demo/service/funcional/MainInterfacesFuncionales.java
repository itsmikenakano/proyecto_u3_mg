package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.uce.edu.demo.repository.modelo.Cliente;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}

	public static void imprimir(String cadena) {
		System.out.println(cadena);
	}

	public static boolean comprobar(String nombre, String letra) {
		return nombre.contains(letra);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// SUPPLIER
		// JAVA
		LOG.info("JAVA Supplier");
		Random r = new Random();
		Stream<Integer> supplier = Stream.generate(() -> r.nextInt(20)).limit(5);
		supplier.sorted().forEach(numero -> System.out.println("Numero Ordenado: " + numero));

		// CONSUMER
		// JAVA
		LOG.info("JAVA Consumer");
		List<String> listaNombres = Arrays.asList("Jhoan", "Robin", "Jostin", "Vanesa", "Luis");
		listaNombres.forEach(nombre -> System.out.println("Inicial del nombre: " + nombre.charAt(0)));

		// PREDICATE
		// JAVA
		LOG.info("JAVA Predicate");
		Stream<String> nuevaLista = listaNombres.stream().filter(nombre -> comprobar(nombre, "o"));
		nuevaLista.forEach(nombre -> System.out.println("Nombres que tienen o : " + nombre));

		// FUNCTION
		// JAVA
		LOG.info("JAVA Function");
		// Conversiones/cast Empleado -> EmpleadoDTO (ligero)
		Stream<Integer> listaCambiada = listaNombres.stream().map(nombre -> {
			Integer longitud = nombre.length();
			return longitud;
		});
		listaCambiada.forEach(longitud -> System.out.println("Longitud del nombre: " + longitud));

	}

}
