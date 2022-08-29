package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IClienteUnitaryOperator<T>{
	T apply(T arg1);
}
