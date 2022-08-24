package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Producto p) {
		this.iProductoRepository.actualizar(p);

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Producto buscarPorCodigoBarra(String codigo) {

		return this.iProductoRepository.buscarPorCodigoBarra(codigo);
	}


	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto p) {
		this.iProductoRepository.insertar(p);

	}

}
