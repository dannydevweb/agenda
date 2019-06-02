import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.PeticionLinea;
import operaciones.ServicioLecturaFicheroPeticion;
import operaciones.ServicioMapaPeticiones;

public class App {

	public static void main(String[] args) {

		ServicioLecturaFicheroPeticion slfp = new ServicioLecturaFicheroPeticion();
		slfp.setPeticionesDesdeFichero();
		List<PeticionLinea> peticiones = slfp.getPeticiones();

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

		}
	}
}
