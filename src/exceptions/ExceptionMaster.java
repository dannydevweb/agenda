package exceptions;

import java.util.ArrayList;
import java.util.List;

public class ExceptionMaster extends Exception {

	public static List<String> errorListLog = new ArrayList<>();

	public ExceptionMaster() {
		super("Excepcion generada");
	}

	public static List<String> getErrorListLog() {
		return errorListLog;
	}

	public static void setErrorListLog(String error) {
		ExceptionMaster.errorListLog.add(error + " " + error.getClass());
	
	}
}
