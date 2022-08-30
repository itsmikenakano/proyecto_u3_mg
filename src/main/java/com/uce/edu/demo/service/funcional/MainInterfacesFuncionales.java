package com.uce.edu.demo.service.funcional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.uce.edu.demo.repository.modelo.Cliente;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static boolean prueba(Integer numero) {
		return numero>=3;
	}
	
	public static void imprimir(String cadena) {
		System.out.println(cadena);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		Cliente c = new Cliente();
		c.setNumeroTarjeta("9090 9787 0154 2342");

		// SUPPLIER
		//Clases
		IClienteSupplier<String> supplierClase = new ClienteSupplierImpl();
		LOG.info("Supplier Clase: " + supplierClase.get());
		
		//LAMBDA
		IClienteSupplier<String> supplierCliente = () -> c.getNumeroTarjeta().replaceAll(" ", "");
		LOG.info("Supplier Cliente: " + supplierCliente.get());

		// Metodos High Order
		String valorCensurado = metodosHO.consumirSupplierCliente(supplierCliente);
		LOG.info("Cliente HO Supplier: " + valorCensurado);
		
		//JAVA
		LOG.info("JAVA Supplier" );
		Stream<String> test = Stream.generate(() -> "Michael 3").limit(7);
		test.forEach(cadena -> System.out.println(cadena));

		// CONSUMER
		// Clases
		IClienteConsumer<Cliente> consumerClase = new ClienteConsumerImpl();
		consumerClase.accept(c);
		
		//LAMBDA
		IClienteConsumer<Cliente> consumerCliente = cliente -> LOG
				.info("Numero tarjeta cliente: " + cliente.getNumeroTarjeta());
		consumerCliente.accept(c);

		// Metodos High Order
		metodosHO.consumirConsumerCliente(numero -> LOG.info("Se ha verificado la tarjete con numero: " + numero),
				c.getNumeroTarjeta());
		//JAVA
		LOG.info("JAVA Consumer" );
		List<Integer> listaNumeros=Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(numero -> System.out.println(numero));

		// PREDICATE
		// Clases
		IClientePredicate<Cliente> predicateClase = new ClientePredicateImpl();
		LOG.info("Predicate Clase: " + " Tarjeta Valida: " + predicateClase.evaluar(c));
		//LAMBDA
		
		IClientePredicate<Cliente> predicateCliente = cliente -> cliente.getNumeroTarjeta().replaceAll(" ", "")
				.length() == 16;
		LOG.info("Predicate Cliente: " + " Tarjeta Valida: " + predicateCliente.evaluar(c));
	
		// Metodos High Order
		boolean validacion = metodosHO.consumirPredicateCliente(cedula -> cedula.length() == 10, "2300290992");
		LOG.info("HO Cliente Predicate: " + validacion);
		
		//JAVA
		LOG.info("JAVA Predicate" );
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> prueba(numero));
		nuevaLista.forEach(numero -> System.out.println(numero));
		
		// FUNCTION
		// Clases
		IClienteFunction<Integer, String> functionClase = new ClienteFunctionImpl();
		LOG.info("Function Clase: Numero digitos Cedula: " + functionClase.aplicar("2300290992"));
		//LAMBDA
		IClienteFunction<Integer, String> functionCliente = cedula -> cedula.length();
		LOG.info("Function Cliente: " + functionCliente.aplicar("2300290992"));

		// Metodos High Order
		Integer valor = metodosHO.consumirFunctionCliente(cadena -> cadena.lastIndexOf('M'), "Michael");
		LOG.info("HO FunctionCliente : " + valor);
		
		//JAVA
		LOG.info("JAVA Function" );
		//Conversiones/cast Empleado -> EmpleadoDTO (ligero)
		Stream<String> listaCambiada=listaNumeros.stream().map(numeroLista -> {
			Integer valor1 = numeroLista +1;
			String cadena = "num: " +valor1.toString();
			return cadena;
			});
		
		//Declarativa: ideas/intenciones
		listaCambiada.forEach(valor2 -> imprimir(valor2));
		
		List<String> lista1=new ArrayList<>();
		HashMap<String, String> map1= new HashMap<String, String>();
		
		//Imperativa: paso a paso
//		for(String valor4: ) {
//			imprimir(valor4);
//		}
		
		// UNARYOPERATOR (FUNCTION)
		// Clases
		IClienteUnitaryOperator<String> unaryClienteClase = new ClienteUnaryOperatorImpl();
		LOG.info("UnaryOperatorCliente Clase: " +unaryClienteClase.apply("Luisa"));		
		//LAMBDA
		IClienteUnitaryOperator<String> unaryCliente = nombre -> "Cliente Afiliado: " + nombre;
		LOG.info("UnaryOperator Cliente: " + unaryCliente.apply("Michael"));
		// Metodos High Order
		String impresion=metodosHO.consumirUnaryOperatorCliente(cadena -> cadena.concat("2300290992"), "Cedula Cliente Afiliado: ");
		LOG.info("UnaryOperator Cliente: " + impresion);
	}

}
