package exceptions;

public class FechaFinalAnteriorAFechaInicalException extends ExceptionMaster {

	private String error = "La fecha Final es anterior a la fecha Inicial";
	
	public FechaFinalAnteriorAFechaInicalException() {
		super();
	}

	public String getError() {
		return error;
	}
}
