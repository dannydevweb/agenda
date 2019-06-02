package modelo;

public class Peticiones {

	private String actividad, espacio, fecha_inicial,fecha_final,dias,horas;

	public Peticiones(String actividad, String espacio, String fecha_inicial, String fecha_final, String dias, String horas) {
	this.actividad = actividad;
	this.espacio = espacio;
	this.fecha_inicial = fecha_inicial;
	this.fecha_final = fecha_final;
	this.dias = dias;
	this.horas = horas;
}

	@Override
	public String toString() {
		return "Peticion [actividad=" + actividad + ", espacio=" + espacio + ", fecha_inicial=" + fecha_inicial
				+ ", fecha_final=" + fecha_final + ", dias=" + dias + ", horas=" + horas + "]";
	}

}
