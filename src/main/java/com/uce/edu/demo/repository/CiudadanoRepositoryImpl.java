package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Ciudadano;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Ciudadano c) {
		this.entityManager.persist(c);
		
	}

}
