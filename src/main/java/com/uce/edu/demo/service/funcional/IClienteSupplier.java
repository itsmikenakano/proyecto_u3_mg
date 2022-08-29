package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IClienteSupplier<T> {
	
	public T get();
	
}
