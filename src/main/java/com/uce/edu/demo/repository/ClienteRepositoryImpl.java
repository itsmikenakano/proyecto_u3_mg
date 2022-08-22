package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscarPorCedula(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery(
				"SELECT cl FROM Cliente cl JOIN cl.ciudadano c WHERE c.cedula = :datoCedula", Cliente.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
		
	}

}
