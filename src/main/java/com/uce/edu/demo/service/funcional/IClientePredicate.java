package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IClientePredicate<T> {
	
	public boolean evaluar(T arg);

}
