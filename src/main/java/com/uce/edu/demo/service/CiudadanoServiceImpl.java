package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoRepository;
import com.uce.edu.demo.repository.modelo.Ciudadano;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{
	
	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Ciudadano c) {
		this.iCiudadanoRepository.insertar(c);
		
	}

}
