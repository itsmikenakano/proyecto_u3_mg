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

	@Autowired
	private IClienteRepository iClienteRepository;

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;
	
	@Autowired
	private IDetalleFacturaRepository iDetalleFacturaRepository;

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
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void comprar(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
		this.transaccionSupermaxi(cedulaCliente, numeroFactura, codigoBarras);
		this.transaccionSri(numeroFactura);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto p) {
		this.iProductoRepository.insertar(p);

	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public void transaccionSupermaxi(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
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
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void transaccionSri(String numeroFactura) {
		List<DetalleFactura> detalles = this.iDetalleFacturaRepository.buscarPorNumeroFactura(numeroFactura);
		System.out.println(detalles.size());
		// 3.Insertar la factura electrónica en el SRI
		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setNumero(numeroFactura);
		facturaElectronica.setFecha(LocalDateTime.now());
		facturaElectronica.setItem(detalles.size());
		BigDecimal montoTotal = new BigDecimal(0);
		for (DetalleFactura d : detalles) {
			montoTotal = montoTotal.add(d.getSubtotal());
		}
		facturaElectronica.setMonto(montoTotal);

		this.iFacturaElectronicaRepository.insertar(facturaElectronica);
	}

}
