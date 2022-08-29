package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

import com.uce.edu.demo.repository.modelo.Cliente;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

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

		// PREDICATE
		// Clases
		IClientePredicate<Cliente> predicateClase = new ClientePredicateImpl();
		LOG.info("Predicate Clase: " + " Tarjeta Valida: " + predicateClase.evaluar(c));
		//LAMBDA
		
		IClientePredicate<Cliente> predicateCliente = cliente -> cliente.getNumeroTarjeta().replaceAll(" ", "")
				.length() == 16;
		LOG.info("Predicate Cliente: " + " Tarjeta Valida: " + predicateCliente.evaluar(c));
//		
//		// Metodos High Order
		boolean validacion = metodosHO.consumirPredicateCliente(cedula -> cedula.length() == 10, "2300290992");
		LOG.info("HO Cliente Predicate: " + validacion);

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
