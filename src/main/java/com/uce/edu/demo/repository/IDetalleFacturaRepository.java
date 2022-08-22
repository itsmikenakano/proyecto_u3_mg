package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.DetalleFactura;

public interface IDetalleFacturaRepository {
	
	public List<DetalleFactura> buscarPorNumeroFactura(String numero);

}
