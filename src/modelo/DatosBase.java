package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DatosBase {
	
	private int mes;
	private int anyo;
	private String actividad;
	private LinkedHashMap<String, String> tablaInicial = new LinkedHashMap();
	
	public DatosBase(int mes, int anyo, String actividad) {
		this.mes = mes;
		this.anyo = anyo;
		this.actividad = actividad;
		this.tablaInicial = tablaInicial;
	}

	public void generaDatosInicial(){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setMinimalDaysInFirstWeek(1);
		calendar.set(this.anyo, this.mes, 1);
		String franja;
		String claveFechaFranja = "";
		int ultimoDiaMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1; i<=ultimoDiaMes;i++){
			int dd = calendar.get(Calendar.DATE);
			
			int mm = calendar.get(Calendar.MONTH)+1;
			
			int yy = calendar.get(Calendar.YEAR);
			
			for (int z = 0; z < 24; z++) {
			     franja = z + "-" + (z+1);
			     claveFechaFranja = dd+"/"+mm+"/"+yy+"_"+franja;
			     tablaInicial.put(claveFechaFranja, actividad);
		     }
			calendar.add(Calendar.DAY_OF_YEAR, 1);
		}
	}

	public LinkedHashMap<String, String> getTablaInicial() {
		return tablaInicial;
	}
}