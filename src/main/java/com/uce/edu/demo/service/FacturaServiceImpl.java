package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Autowired
	private IClienteRepository iClienteRepository;
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
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

	@Override
	public void insertar(Factura f) {
		this.iFacturaRepository.insertar(f);

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarFactura(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
		// 1.Crear una factura con los detalles
		Factura factura = new Factura();
		factura.setCliente(this.iClienteRepository.buscarPorCedula(cedulaCliente));
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroFactura);
		List<DetalleFactura> detalles = new ArrayList<>();
		List<Producto> productos = new ArrayList<>();
		// detalles
		for (String codigo : codigoBarras) {
			Producto p = this.iProductoRepository.buscarPorCodigoBarra(codigo);
			productos.add(p);
			DetalleFactura detalle = new DetalleFactura();
			detalle.setProducto(p);
			detalle.setCantidad(1);
			detalle.setSubtotal(p.getPrecio());
			detalle.setFactura(factura);
			detalles.add(detalle);
		}
		factura.setDetalles(detalles);
		this.iFacturaRepository.insertar(factura);

		// 2.Actualizar el stock
		for (Producto p : productos) {
			p.setStock(p.getStock() - 1);
			this.iProductoRepository.actualizar(p);
		}
	}

}
