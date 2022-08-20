package com.uce.edu.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class HotelServiceImplTest {
	
	@Autowired
	private IHotelRepository iHotelRepository;
	
	@Test
	public void buscarHotelInnerJoin() {
		
		List<Hotel> hoteles = this.iHotelRepository.buscarHotelInnerJoin("Individual");
		assertNotNull(hoteles);
		
	}

}
