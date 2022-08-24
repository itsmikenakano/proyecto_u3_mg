package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.FacturaElectronica;

public interface IFacturaElectronicaService {
	
	public void insertar(FacturaElectronica f);
	
	public void transaccionSri(String numeroFactura);
	
}
