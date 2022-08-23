package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaConsumer<T> {
	public void accept(T arg1);
}
