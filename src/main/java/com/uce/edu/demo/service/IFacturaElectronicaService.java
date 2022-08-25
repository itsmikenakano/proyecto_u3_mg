package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.modelo.FacturaElectronica;

public interface IFacturaElectronicaService {

	public void insertar(FacturaElectronica f);

	public void procesarElectronica(String numeroFactura, Integer cantidadItems, BigDecimal monto);

}
