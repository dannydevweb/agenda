package app;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import exceptions.ExceptionMaster;
import ficheros.GenerarHtml;
import ficheros.LeerFicheroConfig;
import ficheros.LeerFicheroIdiomas;
import ficheros.LeerFicheroPeticiones;
import modelo.DatosBase;
import modelo.PeticionLinea;
import modelo.Peticiones;
import operaciones.ServicioLecturaFicheroPeticion;
import operaciones.ServicioMapaPeticiones;

public class App {

	public static void main(String[] args) {

		ServicioLecturaFicheroPeticion slfp = new ServicioLecturaFicheroPeticion();
		slfp.setPeticionesDesdeFichero();
		List<PeticionLinea> peticiones = slfp.getPeticiones();

		//************************************************de Ebert*******************
		//Leer fichero configuración
		LeerFicheroConfig configuracion = new LeerFicheroConfig();
		configuracion.leerfileconfig();
		
		DatosBase db = new DatosBase((Integer.parseInt(configuracion.dame_mes())-1), Integer.parseInt(configuracion.dame_any()), "Disponible");
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

//************************************************de Ebert*******************
		
		//System.out.println("Idioma salida: " + configuracion.dame_idioma());
		//System.out.println("Fichero idioma de entrada: " + configuracion.idioma_entrada());
		//System.out.println("Fichero idioma de salida: " + configuracion.idioma_salida());
		
		//Leer fichero idioma de entrada
		String ficheroidioma;
		ficheroidioma = configuracion.idioma_entrada();
		//System.out.println("\nIdioma de entrada:" + " \"" + ficheroidioma +"\"");
		//System.out.println("--------------------------------------");
		LeerFicheroIdiomas idiomaentrada = new LeerFicheroIdiomas();
		idiomaentrada.leeidioma(ficheroidioma);
				
		//Leer fichero idioma de salida
		ficheroidioma = configuracion.idioma_salida();
		//System.out.println("\nIdioma de salida:" + " \"" + ficheroidioma +"\"");
		//System.out.println("-------------------------------------");
		LeerFicheroIdiomas idiomasalida = new LeerFicheroIdiomas();
		idiomasalida.leeidioma(ficheroidioma);
		String diasCabeceraHtml=idiomasalida.diasidioma();
		String[] textElements = diasCabeceraHtml.split(",");
		
 
		//Leer fichero de peticiones
		//System.out.println("\nFichero de peticiones: peticions.txt");
		//System.out.println("------------------------------------");
		//LeerFicheroPeticiones serv = new LeerFicheroPeticiones();
		//List<Peticiones> peticion = serv.getPeticionDesdeFichero(NOM_FICHERO);
		/*for(int i=0;i<peticion.size();i++){
			System.out.println(peticion.get(i));
		}*/
		//System.out.println(peticion.size());
		
		//Genera Mapa Ejemplo
		//DatosBase db = new DatosBase((Integer.parseInt(configuracion.dame_mes())-1), Integer.parseInt(configuracion.dame_any()), "Free");
		//db.generaDatosInicial();

		
		//Genera fichero html
		System.out.println("\nGenera Fichero html: *.html");
		System.out.println("------------------------------------");
		GenerarHtml crearHtml = new GenerarHtml();
		crearHtml.generafichero(mapaOriginal);
	}
}
