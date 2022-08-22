package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3MgApplication.class);

	@Autowired
	private ICiudadanoService iCiudadanoService;

	@Autowired
	private IProductoService iProductoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ciudadano c = new Ciudadano();
		c.setApellido("Garcia");
		c.setNombre("Michael");
		c.setCedula("2300290992");
		
		Cliente cliente = new Cliente();
		cliente.setNumeroTarjeta("1224");
		cliente.setCiudadano(c);
		c.setCliente(cliente);
		//this.iCiudadanoService.insertar(c);
		
		Producto p = new Producto();
		p.setNombre("Pan Supan");
		p.setPrecio(new BigDecimal(1.30));
		p.setCodigoBarra("002");
		p.setStock(100);
		//this.iProductoService.insertar(p);
		
		List<String> codigosBarras= new ArrayList<>();
		codigosBarras.add("001");
		codigosBarras.add("002");
	
		
		this.iProductoService.comprar("2300290992", "0001", codigosBarras);
		
	}

}
