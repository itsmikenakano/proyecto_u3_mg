package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorCompraImpl implements IGestorCompra {

	@Autowired
	private IFacturaElectronicaService iFacturaElectronicaService;

	@Autowired
	private IFacturaService iFacturaService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarCompra(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
		BigDecimal totalPagar = this.iFacturaService.procesarFactura(cedulaCliente, numeroFactura, codigoBarras);

		this.iFacturaElectronicaService.procesarElectronica(numeroFactura, codigoBarras.size(), totalPagar);

	}

}
