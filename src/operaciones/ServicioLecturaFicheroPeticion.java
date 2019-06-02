package operaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import exceptions.NumeroDeFranjasMayorACincoException;
import modelo.PeticionLinea;
import modelo.UtilesFecha;

public class ServicioLecturaFicheroPeticion {

	private List<PeticionLinea> peticiones = new ArrayList<>();
	public static final String NOM_FICHERO = "peticions.txt";
	
	public void setPeticionesDesdeFichero() {
		File fichero = new File(NOM_FICHERO);
		try(Scanner sc = new Scanner(fichero)) {
			while(sc.hasNextLine()) {
				String lin = sc.nextLine(); // Lee la linea actual
					PeticionLinea p = crearPeticion(lin);
					peticiones.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

	private PeticionLinea crearPeticion(String lin) {
		//Tancat Sala1 01/01/2008 31/12/2008 LMCJVSG 00-07_21-24
		final byte ACTI=0, SALA=1, FECHIN=2, FECHOUT=3, DIAS=4, FRANJA=5;
		String[] arrayLineaPeticion = lin.split(" ");
		String actividad = arrayLineaPeticion[ACTI];
		String sala = arrayLineaPeticion[SALA];
		UtilesFecha uf = new UtilesFecha();
		Date fechaInicial = uf.string2Date(arrayLineaPeticion[FECHIN]);
		Date fechaFinal = uf.string2Date(arrayLineaPeticion[FECHOUT]);
		ServicioDiasPeticion sdp = new ServicioDiasPeticion();
		ArrayList<Integer> diasPeticion = sdp.generarArrayDiaNumero(arrayLineaPeticion[DIAS], "CAT");
		ServicioFranjaHorariaEnPeticion fran = new ServicioFranjaHorariaEnPeticion();
		ArrayList<String> franjaHoraria = new ArrayList<>();
		try {
			franjaHoraria = fran.franjaLargaACorta(arrayLineaPeticion[FRANJA]);
		} catch (NumeroDeFranjasMayorACincoException e) {
			e.printStackTrace();
		}

		return new PeticionLinea(actividad, sala, fechaInicial, fechaFinal, diasPeticion, franjaHoraria);
	}

	public List<PeticionLinea> getPeticiones() {
		return peticiones;
	}
	
	
}
