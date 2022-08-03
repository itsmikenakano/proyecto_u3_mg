package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelService {
	
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	public List<Hotel> buscarInnerJoin();
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion);
	public List<Hotel> buscarOuterJoinLeft();
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion);
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion);
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion);

}
