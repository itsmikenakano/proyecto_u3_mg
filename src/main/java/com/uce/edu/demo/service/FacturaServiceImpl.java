package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {

		return this.iFacturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarInnerJoin() {

		return this.iFacturaRepository.buscarInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {

		return this.iFacturaRepository.buscarFacturaOuterJoinLeft(cantidad);
	}

	@Override
	public List<Factura> buscarOuterJoinLeft() {

		return this.iFacturaRepository.buscarOuterJoinLeft();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {

		return this.iFacturaRepository.buscarFacturaOuterJoinRight(cantidad);

	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {

		return this.iFacturaRepository.buscarFacturaJoinWhere(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {

		return this.iFacturaRepository.buscarFacturaFetchJoin(cantidad);

	}

}
