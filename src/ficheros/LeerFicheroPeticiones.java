package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import modelo.Peticiones;



public class LeerFicheroPeticiones {

	public List<Peticiones> getPeticionDesdeFichero(String nomFichero) {
			List<Peticiones> peticion = Collections.emptyList();
			File fichero = new File(nomFichero);
			try( Scanner sc = new Scanner(fichero)) {
				peticion = new ArrayList<>();
				
				while(sc.hasNextLine()) {
					String lin = sc.nextLine();
					Peticiones agenda = crearPeticiones(lin);
					peticion.add(agenda);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return peticion;
			
		}
	
		private Peticiones crearPeticiones(String lin) {
			
			final byte ACTIVIDAD=0, ESPACIO=1, FECHA_INICIAL=2, FECHA_FINAL=3, DIAS=4, HORAS=5;
		
			String [] arrayPartesPeticiones = lin.split(" ");
			
			String actividad = arrayPartesPeticiones[ACTIVIDAD];
			String espacio = arrayPartesPeticiones[ESPACIO];
			String fecha_inicial = arrayPartesPeticiones[FECHA_INICIAL];
			String fecha_final = arrayPartesPeticiones[FECHA_FINAL];
			String dias = arrayPartesPeticiones[DIAS];
			String horas = arrayPartesPeticiones[HORAS];
			
			return new Peticiones(actividad, espacio, fecha_inicial, fecha_final, dias, horas);
		}

}
