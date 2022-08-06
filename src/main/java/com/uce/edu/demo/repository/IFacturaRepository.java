package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);

	public List<Factura> buscarInnerJoin();

	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad);

	public List<Factura> buscarOuterJoinLeft();

	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);

}
