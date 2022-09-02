package com.uce.edu.demo.hilos.paralelo;

import java.util.List;

public class DoctorParalelo {

	private String nombre;
	private List<String> pacientes;

	public DoctorParalelo(String nombre, List<String> pacientes) {
		super();
		this.nombre = nombre;
		this.pacientes = pacientes;
	}

	@Override
	public String toString() {
		return nombre;
	}

	// SET Y GET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<String> pacientes) {
		this.pacientes = pacientes;
	}

}
