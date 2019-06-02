package operaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.ExceptionMaster;
import exceptions.FranjaHorariaErroneaException;
import exceptions.NumeroDeFranjasMayorACincoException;


public class ServicioFranjaHorariaEnPeticion {

	public ArrayList<String> franjaPeticion = new ArrayList<>();

	public ArrayList<String> franjaLargaACorta(String franjaLarga) throws NumeroDeFranjasMayorACincoException {
	
		franjaPeticion = new ArrayList<>();
		String[] arrayFranjaLarga = franjaLarga.split("_");
		
		if(arrayFranjaLarga.length>5) {
			NumeroDeFranjasMayorACincoException e = new NumeroDeFranjasMayorACincoException();
			ExceptionMaster.setErrorListLog(e.getError());
			return franjaPeticion;
		} else {
			for (int i = 0; i < arrayFranjaLarga.length; i++) {
				try {
					generaFranjaCorta(arrayFranjaLarga[i]);
				} catch (FranjaHorariaErroneaException e) {
					e.printStackTrace();
					}
				}
			return franjaPeticion;
		}
	}

	public void generaFranjaCorta(String franja) throws FranjaHorariaErroneaException{
		
		String[] desdeHasta = franja.split("-");
		int nHoras = Integer.parseInt(desdeHasta[1]) - Integer.parseInt(desdeHasta[0]);
		if(nHoras>0){
		for (int i = Integer.parseInt(desdeHasta[0]); i < Integer.parseInt(desdeHasta[1]); i++) {
			String franjaCorta = i + "-" + (i+1);
			franjaPeticion.add(franjaCorta);
		}
		} else {
			FranjaHorariaErroneaException e = new FranjaHorariaErroneaException();
			ExceptionMaster.setErrorListLog(e.getError());
			
		}
	}
	
}

