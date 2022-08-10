package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuba_id_seq")
	@SequenceGenerator(name = "cuba_id_seq", sequenceName = "cuba_id_seq", allocationSize = 1)
	@Column(name = "cuba_id")
	private Integer id;

	@Column(name = "cuba_numero")
	private String numero;

	@Column(name = "cuba_saldo")
	private BigDecimal saldo;

	@Column(name = "cuba_tipo")
	private String tipo;

	@OneToMany(mappedBy = "cuentaOrigen", fetch = FetchType.LAZY)
	private List<Transferencia> transferenciasOrigen;

	@OneToMany(mappedBy = "cuentaDestino", fetch = FetchType.LAZY)
	private List<Transferencia> transferenciasDestino;

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Transferencia> getTransferenciasOrigen() {
		return transferenciasOrigen;
	}

	public void setTransferenciasOrigen(List<Transferencia> transferenciasOrigen) {
		this.transferenciasOrigen = transferenciasOrigen;
	}

	public List<Transferencia> getTransferenciasDestino() {
		return transferenciasDestino;
	}

	public void setTransferenciasDestino(List<Transferencia> transferenciasDestino) {
		this.transferenciasDestino = transferenciasDestino;
	}

}
