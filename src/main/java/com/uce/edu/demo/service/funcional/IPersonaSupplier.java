package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaSupplier<T> {
	public T getNombre();
}
