package operaciones;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class ServicioMapaPeticiones {

	private String actividad;
	private String sala;
	private ArrayList<String> franjaHora = new ArrayList<>();
	private LinkedHashMap<String, String> franjaHoraActividad = new LinkedHashMap<>();
	
	private ArrayList<Integer> diasPeticion = new ArrayList<>();
	private LinkedHashMap<String, Integer> fechaDiaNumerodia = new LinkedHashMap<>();
	private Date fechaInicial, fechaFinal;

	private LinkedHashMap<String, String> mapaPeticiones = new LinkedHashMap<>(); 

	
	public ServicioMapaPeticiones(String actividad, String sala, ArrayList<String> franjaHora, 
					ArrayList<Integer> diasPeticion, Date fechaInicial,Date fechaFinal) {
		this.actividad = actividad;
		this.sala = sala;
		this.franjaHora = franjaHora;
		this.diasPeticion = diasPeticion;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		String[] array = franjaHora.toArray(new String[] {});
		for (int i = 0; i < array.length; i++) {
			this.franjaHoraActividad.put(array[i], actividad);
		}
		mapaFechas();
	}

	
	public void mapaFechas() {
		//Integer[] array = diasPeticion.toArray(new Integer[] {});
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicial);
		int dayOftheWeek = calendar.get(Calendar.DAY_OF_WEEK);
		Date fecha = calendar.getTime();
		//System.out.println(fecha);
		while(!fechaFinal.before(fecha)){
			if(diasPeticion.contains(dayOftheWeek)){ 
				int dd = calendar.get(Calendar.DATE);
				int mm = calendar.get(Calendar.MONTH)+1;
				int yy = calendar.get(Calendar.YEAR);
				String fechaString = dd + "/" + mm + "/" + yy;
				this.fechaDiaNumerodia.put(fechaString, dayOftheWeek);
				}

		//System.out.println(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		fecha = calendar.getTime();

		dayOftheWeek = calendar.get(Calendar.DAY_OF_WEEK);
		}
	}
	
	public void mapaDatosPeticiones() {
		for (Entry<String, String> entry : franjaHoraActividad.entrySet()) {
		    String fra = entry.getKey(), act = entry.getValue();
		    for (Entry<String, Integer> entry1 : fechaDiaNumerodia.entrySet()) {
			String fec = entry1.getKey(); 
			int diaN = entry1.getValue();
			mapaPeticiones.put(fec+"_"+fra, act);
		    }
		}
	}


	public LinkedHashMap<String, String> getMapaPeticiones() {
		return mapaPeticiones;
	}


	public LinkedHashMap<String, String> getFranjaHoraActividad() {
		return franjaHoraActividad;
	}


	public LinkedHashMap<String, Integer> getFechaDiaNumerodia() {
		return fechaDiaNumerodia;
	}
	
		
	
}
