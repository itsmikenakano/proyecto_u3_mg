package com.uce.edu.demo.service.funcional;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		/*
		 * String valor=funcion.getNombre(); //Calcular/sumar consultar base, etc...
		 * Integer numero = Integer.parseInt(valor); return numero;
		 */

		return funcion.getNombre() + " Se proceso el dato";
	}

	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
	}

	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {

		return funcion.evaluar(valor);

	}

	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor);

	}

	public void consumirConsumerCliente(IClienteConsumer<String> funcion, String numero) {

		funcion.accept(numero);
	}
	
	public String consumirSupplierCliente(IClienteSupplier<String> funcion) {
		return "XXXX XXXX XXXX " +funcion.get().substring(funcion.get().length()-4, funcion.get().length());
	}
	
	public boolean consumirPredicateCliente(IClientePredicate<String> funcion, String cedula) {
		return funcion.evaluar(cedula);
	}
	
	public Integer consumirFunctionCliente(IClienteFunction<Integer, String> funcion, String cadena) {
		return funcion.aplicar(cadena);
	}
	
	public String consumirUnaryOperatorCliente(IClienteUnitaryOperator<String> funcion, String cadena) {
		
		return funcion.apply(cadena);
		
	}

}
