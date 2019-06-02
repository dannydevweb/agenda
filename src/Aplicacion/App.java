package Aplicacion;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import exceptions.ExceptionMaster;
import modelo.DatosBase;
import modelo.PeticionLinea;
import operaciones.ServicioLecturaFicheroPeticion;
import operaciones.ServicioMapaPeticiones;

public class App {

	public static void main(String[] args) {

		ServicioLecturaFicheroPeticion slfp = new ServicioLecturaFicheroPeticion();
		slfp.setPeticionesDesdeFichero();
		List<PeticionLinea> peticiones = slfp.getPeticiones();

		DatosBase db = new DatosBase(10, 2008, "Disponible");
		db.generaDatosInicial();
		LinkedHashMap<String, String> mapaOriginal = db.getTablaInicial();
		//mapaOriginal.forEach((k, v) -> System.out.println("Clave: " + k + " Valor: " + v));
	
		//peticiones.forEach(System.out::println);
		for (int i = 0; i < peticiones.size(); i++) {

			PeticionLinea pl = peticiones.get(i);

			ServicioMapaPeticiones smp = new ServicioMapaPeticiones(pl.getActividad(), pl.getSala(),
					pl.getFranjaHoraria(), pl.getDiasPeticion(), pl.getFechaInicial(), pl.getFechaFinal());

			// smp.getFechaDiaNumerodia().forEach((k,v) ->
			// System.out.println("Clave: " + k + " Valor: " + v));
			// smp.getFranjaHoraActividad().forEach((k,v) ->
			// System.out.println("Clave: " + k + " Valor: " + v));

			smp.mapaDatosPeticiones();
			// smp.getMapaPeticiones().forEach((k,v) ->
			// System.out.println("Clave: " + k + " Valor: " + v));
			System.out.println(smp.getMapaPeticiones().size());
			
			for (Map.Entry<String, String> entry : smp.getMapaPeticiones().entrySet()) {
			    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
				if(mapaOriginal.containsKey(entry.getKey())) {
					mapaOriginal.replace(entry.getKey(), entry.getValue());
				}
			}
			
		}
		
		
		ExceptionMaster e = new ExceptionMaster();
		e.getErrorListLog().forEach(System.out::println);;

		mapaOriginal.forEach((k, v) -> System.out.println("Clave: " + k + " Valor: " + v));


	}
}
