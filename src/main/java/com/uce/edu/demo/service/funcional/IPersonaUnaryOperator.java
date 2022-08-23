package com.uce.edu.demo.service.funcional;
@FunctionalInterface
public interface IPersonaUnaryOperator<T> {
	T apply(T arg1);
}
