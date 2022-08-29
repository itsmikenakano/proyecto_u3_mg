package com.uce.edu.demo.service.funcional;

import com.uce.edu.demo.repository.modelo.Cliente;

public class ClienteConsumerImpl implements IClienteConsumer<Cliente>{

	@Override
	public void accept(Cliente arg) {
		System.out.println("Consumer Clase: " + "Numero tarjeta cliente: " + arg.getNumeroTarjeta());
		
	}

}
