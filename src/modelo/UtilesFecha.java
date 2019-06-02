package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilesFecha {

	public static Date ints2Date(int d, int m, int a) {
		String presuntaFecha = d + "/" + m + "/" + a;
		return string2Date(presuntaFecha);
	}
	
	/**
	 * Este metodo asume que el string proporcionado sigue el patron dd/MM/yyyy
	 * @param presuntaFecha
	 * @return Un objeto Date o lanza RunTimeException si no se cumple el formato dd/MM/yyyy
	 */
	public static Date string2Date(String presuntaFecha) {
		return string2Date(presuntaFecha, "dd/MM/yyyy");
	}
	
	/**
	 * Este metodo no asume ningun patron de formato
	 * @param presuntaFecha
	 * @return Un objeto Date o lanza RunTimeException si no se cumple el formato que se le pasa
	 */
	public static Date string2Date(String presuntaFecha, String patron) {
		DateFormat df = new SimpleDateFormat(patron);
		try {
			return df.parse(presuntaFecha);
		} catch (ParseException e) {
			throw new RuntimeException("El string proporcionado no se ajusta al patrón indicado");
		}
	}
	
	public static String prettyPrint(Date fecha) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(fecha);
	}
	
	public static String prettyPrint(Date fecha, String patron) {
		DateFormat df = new SimpleDateFormat(patron);
		return df.format(fecha);
	}
	
	
}
