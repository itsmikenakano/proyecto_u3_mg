package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoService {

	public void insertar(Producto p);

	public void actualizar(Producto p);

	public Producto buscarPorCodigoBarra(String codigo);

}
