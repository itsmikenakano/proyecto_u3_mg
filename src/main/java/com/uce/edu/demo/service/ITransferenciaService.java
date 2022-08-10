package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface ITransferenciaService {

	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto);
	public void realizarTransferenciaFachada(String cuentaOrigen, String cuentaDestino, BigDecimal monto);

}
