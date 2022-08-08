package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3MgApplication.class);

	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOG.info("RELACIONAMIENTO WHERE");
		List<Factura> listaFacturas = this.iFacturaService.buscarFacturaJoinWhere(4);
		for (Factura f : listaFacturas) {
			LOG.info("Factura: " + " Numero: " + f.getNumero() + " Fecha: " + f.getFecha());
		}

		LOG.info("JOIN FETCH");
		List<Factura> listaFacturas2 = this.iFacturaService.buscarFacturaFetchJoin(4);
		for (Factura f : listaFacturas2) {
			LOG.info("Factura2: " + " Numero: " + f.getNumero() + " Fecha: " + f.getFecha());
			for (DetalleFactura d : f.getDetalles()) {
				LOG.info("Detalle2: " + d);
			}

		}

	}

}
