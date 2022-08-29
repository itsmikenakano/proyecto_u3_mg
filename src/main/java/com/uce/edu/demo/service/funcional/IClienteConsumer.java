package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IClienteConsumer<T> {
	public void accept(T arg);
}
