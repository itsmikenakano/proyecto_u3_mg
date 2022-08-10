package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3MgApplication.class);

	@Autowired
	private IHotelService iHotelService;

	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		this.iTransferenciaService.realizarTransferenciaFachada("345345", "1312312", new BigDecimal(1));
	}

}
