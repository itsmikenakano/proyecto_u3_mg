package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaFunction<R,T> {
	public R aplicar(T arg1);
}
