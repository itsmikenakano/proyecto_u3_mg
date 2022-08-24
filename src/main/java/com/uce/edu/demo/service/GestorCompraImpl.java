package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorCompraImpl implements IGestorCompra{
	
	@Autowired
	private IFacturaElectronicaService iFacturaElectronicaService;

	@Autowired
	private IFacturaService iFacturaService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarCompra(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
		this.iFacturaService.procesarFactura(cedulaCliente, numeroFactura, codigoBarras);
		
		this.iFacturaElectronicaService.transaccionSri(numeroFactura);
		
	}

}
