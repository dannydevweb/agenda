package exceptions;

public class NumeroDeFranjasMayorACincoException extends ExceptionMaster {

	private String error = "N�mero de franjas horarias mayor a los 5 permitidos";

	public NumeroDeFranjasMayorACincoException() {
		super();
	}

	public String getError() {
		return error;
	}
}
