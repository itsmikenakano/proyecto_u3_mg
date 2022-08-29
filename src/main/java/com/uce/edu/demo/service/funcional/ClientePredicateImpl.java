package com.uce.edu.demo.service.funcional;

import com.uce.edu.demo.repository.modelo.Cliente;

public class ClientePredicateImpl implements IClientePredicate<Cliente> {

	@Override
	public boolean evaluar(Cliente arg) {

		return arg.getNumeroTarjeta().replaceAll(" ", "").length() == 16;
	}

}
