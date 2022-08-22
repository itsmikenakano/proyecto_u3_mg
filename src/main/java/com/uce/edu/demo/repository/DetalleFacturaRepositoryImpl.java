package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleFactura;

@Repository
@Transactional
public class DetalleFacturaRepositoryImpl implements IDetalleFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<DetalleFactura> buscarPorNumeroFactura(String numero) {
		TypedQuery<DetalleFactura> myQuery = this.entityManager.createQuery(
				"SELECT d FROM DetalleFactura d JOIN d.factura f WHERE f.numero= :datoNumero", DetalleFactura.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getResultList();
	}

}
