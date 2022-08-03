package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3MgApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3MgApplication.class);

	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Hotel> listaHoteles = this.iHotelService.buscarHotelInnerJoin("Matrimonial");
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		List<Hotel> listaHoteles2 = this.iHotelService.buscarInnerJoin();
		for (Hotel h : listaHoteles2) {
			LOG.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
		}

		// LEFT
		List<Hotel> listaHotelesLeft = this.iHotelService.buscarHotelOuterJoinLeft("Matrimonial");
		for (Hotel h : listaHotelesLeft) {
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}

		// LEFT
		List<Hotel> listaHotelesLeft2 = this.iHotelService.buscarOuterJoinLeft();
		for (Hotel h : listaHotelesLeft2) {
			LOG.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
		}

		// RIGHT
		List<Hotel> listaHotelesRight = this.iHotelService.buscarHotelOuterJoinRight("Matrimonial");
		for (Hotel h : listaHotelesRight) {
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
	}

}
