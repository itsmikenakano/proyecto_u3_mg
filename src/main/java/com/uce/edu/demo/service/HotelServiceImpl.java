package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository iHotelRepository;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarInnerJoin() {

		return this.iHotelRepository.buscarInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {

		return this.iHotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarOuterJoinLeft() {

		return this.iHotelRepository.buscarOuterJoinLeft();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		return this.iHotelRepository.buscarHotelFetchJoin(tipoHabitacion);
	}

}
