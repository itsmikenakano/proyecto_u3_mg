package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		//0. Busque la cta Origen (obtener el saldo)
		CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaOrigen);
		//1. Restar el monto de la cta origen
		ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto));
		this.iCuentaBancariaRepository.actualizar(ctaOrigen);
		//0. Busque la cuenta Destino
		CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.buscarPorNumero(numeroCtaDestino);
		//2. Sumar el monto a la cta destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.iCuentaBancariaRepository.actualizar(ctaDestino);
		
		//3.Insertar Transferencia
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.iTransferenciaRepository.insertar(trans);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		this.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
		
	}

}
