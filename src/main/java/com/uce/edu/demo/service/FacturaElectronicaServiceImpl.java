package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{
	
	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(FacturaElectronica f) {
		this.iFacturaElectronicaRepository.insertar(f);
	}

}
