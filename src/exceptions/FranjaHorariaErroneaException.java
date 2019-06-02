package exceptions;

public class FranjaHorariaErroneaException extends ExceptionMaster {

	private String error = "La franja horaria es incorrecta";
	
	public FranjaHorariaErroneaException() {
		super();
	}

	public String getError() {
		return error;
	}
}
