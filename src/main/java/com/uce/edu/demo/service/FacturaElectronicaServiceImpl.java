package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{
	
	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;
	
	@Autowired
	private IDetalleFacturaRepository iDetalleFacturaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(FacturaElectronica f) {
		this.iFacturaElectronicaRepository.insertar(f);
		
	}
	
	@Override
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
		throw new RuntimeException();
	}


}
