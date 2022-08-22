package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {
	
	public void insertar(Producto p);
	
	public void actualizar(Producto p);
	
	public Producto buscarPorCodigoBarra(String codigo);
	
	
}
