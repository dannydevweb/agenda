package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionLinea {
	//Tancat Sala1 01/01/2008 31/12/2008 LMCJVSG 00-07_21-24
	private String actividad;
	private String sala;
	private Date fechaInicial;
	private Date fechaFinal;
	private ArrayList<Integer> diasPeticion;
	private ArrayList<String> franjaHoraria;
	
	public PeticionLinea(String actividad, String sala, Date fechaInicial, Date fechaFinal, ArrayList<Integer> diasPeticion,
			ArrayList<String> franjaHoraria) {
		this.actividad = actividad;
		this.sala = sala;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.diasPeticion = diasPeticion;
		this.franjaHoraria = franjaHoraria;
	}

	public String getActividad() {
		return actividad;
	}

	public String getSala() {
		return sala;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public ArrayList<Integer> getDiasPeticion() {
		return diasPeticion;
	}

	public ArrayList<String> getFranjaHoraria() {
		return franjaHoraria;
	}

	@Override
	public String toString() {
		return "PeticionLinea [actividad=" + actividad + ", sala=" + sala + ", fechaInicial=" + fechaInicial
				+ ", fechaFinal=" + fechaFinal + ", diasPeticion=" + diasPeticion + ", franjaHoraria=" + franjaHoraria
				+ "]";
	}
	
}
