package app;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import exceptions.ExceptionMaster;
import exceptions.FechaFinalAnteriorAFechaInicalException;
import ficheros.GenerarHtml;
import ficheros.LeerFicheroConfig;
import ficheros.LeerFicheroIdiomas;
import modelo.DatosBase;
import modelo.PeticionLinea;
import operaciones.ServicioLecturaFicheroPeticion;
import operaciones.ServicioMapaPeticiones;

public class App {

	public static void main(String[] args) throws FechaFinalAnteriorAFechaInicalException {

		String sala1 = "SALA1", sala2 = "SALA2";

		LeerFicheroConfig configuracion = new LeerFicheroConfig();
		configuracion.leerfileconfig();

		DatosBase db = new DatosBase((Integer.parseInt(configuracion.dame_mes()) - 1),
				Integer.parseInt(configuracion.dame_any()), "Disponible");
		db.generaDatosInicial();

		LinkedHashMap<String, String> mapaOriginal01 = db.getTablaInicial();
		// mapaOriginal.forEach((k, v) -> System.out.println("Clave: " + k + " Valor: " + v));

		LinkedHashMap<String, String> mapaOriginal02 = db.getTablaInicial();
		// mapaOriginal.forEach((k, v) -> System.out.println("Clave: " + k + " Valor: " + v));

		ServicioLecturaFicheroPeticion slfp = new ServicioLecturaFicheroPeticion();
		slfp.setPeticionesDesdeFichero();
		List<PeticionLinea> peticiones = slfp.getPeticiones();
		List<PeticionLinea> peticionesSala01 = new ArrayList<PeticionLinea>();
		List<PeticionLinea> peticionesSala02 = new ArrayList<PeticionLinea>();
		for (int i = 0; i < peticiones.size(); i++) {
			PeticionLinea pl = peticiones.get(i);
			if(pl.getSala().toUpperCase().equals(sala1)) {
				peticionesSala01.add(pl);
			} else if(pl.getSala().toUpperCase().equals(sala2)) {
				peticionesSala02.add(pl);
			}
		}
		
		System.out.println("*************SALA01***********");
		peticionesSala01.forEach(System.out::println);
		System.out.println("*************SALA02***********");
		peticionesSala02.forEach(System.out::println);

		for (int i = 0; i < peticionesSala01.size(); i++) {

			PeticionLinea pl01 = peticionesSala01.get(i);

			ServicioMapaPeticiones smp = new ServicioMapaPeticiones(pl01.getActividad(), pl01.getSala(),
					pl01.getFranjaHoraria(), pl01.getDiasPeticion(), pl01.getFechaInicial(), pl01.getFechaFinal());

			smp.mapaDatosPeticiones();

			for (Map.Entry<String, String> entry1 : smp.getMapaPeticiones().entrySet()) {
				if (mapaOriginal01.containsKey(entry1.getKey())) {
					mapaOriginal01.replace(entry1.getKey(), entry1.getValue());
				}
			}
				}
		
		// para Sala02
		
		for (int i = 0; i < peticionesSala02.size(); i++) {

			PeticionLinea pl02 = peticionesSala02.get(i);

			ServicioMapaPeticiones smp02 = new ServicioMapaPeticiones(pl02.getActividad(), pl02.getSala(),
					pl02.getFranjaHoraria(), pl02.getDiasPeticion(), pl02.getFechaInicial(), pl02.getFechaFinal());

			smp02.mapaDatosPeticiones();

			for (Map.Entry<String, String> entry : smp02.getMapaPeticiones().entrySet()) {
				if (mapaOriginal02.containsKey(entry.getKey())) {
					mapaOriginal02.replace(entry.getKey(), entry.getValue());
				}
			}
		}

		ExceptionMaster e = new ExceptionMaster();
		e.getErrorListLog().forEach(System.out::println);
		
		// Leer fichero idioma de entrada
		String ficheroidioma;
		ficheroidioma = configuracion.idioma_entrada();

		// System.out.println("--------------------------------------");
		LeerFicheroIdiomas idiomaentrada = new LeerFicheroIdiomas();
		idiomaentrada.leeidioma(ficheroidioma);

		// Leer fichero idioma de salida
		ficheroidioma = configuracion.idioma_salida();

		// System.out.println("-------------------------------------");
		LeerFicheroIdiomas idiomasalida = new LeerFicheroIdiomas();
		idiomasalida.leeidioma(ficheroidioma);
		String diasCabeceraHtml = idiomasalida.diasidioma();
		String[] textElements = diasCabeceraHtml.split(",");

		// Genera ficheros html

		GenerarHtml crearHtml01 = new GenerarHtml();
		crearHtml01.generafichero(mapaOriginal01, sala1);
		System.out.println("\nGenera Fichero html: " + sala1 + ".html");
		System.out.println("------------------------------------");

		GenerarHtml crearHtml02 = new GenerarHtml();
		crearHtml02.generafichero(mapaOriginal02, sala2);
		System.out.println("\nGenera Fichero html: " + sala2 + ".html");
		System.out.println("------------------------------------");
	}
}
