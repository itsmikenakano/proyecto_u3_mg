package com.uce.edu.demo.service.funcional;

public class ClienteSupplierImpl implements IClienteSupplier<String>{

	@Override
	public String get() {
		
		return "9090 9787 0154 2342".replaceAll(" ", "");
	}



}
