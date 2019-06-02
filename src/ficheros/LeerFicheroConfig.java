package ficheros;

import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class LeerFicheroConfig {
	
	private static String any="";
	private static String mes="";
	private static String idioma_entrada="internacional.";
	private static String idioma_salida="internacional.";
	private static int semana;
	private static int numeroSemanasMes;
	private static int primerDiaSemanaMes;
	private static int diaMes;
	private static String idioma="";
	private static int semanaAnyo;
	private static int totalSemanasAnyo;
	
	public void leerfileconfig() {

		try {
			System.out.println("Fichero config.txt");
			System.out.println("------------------");
			FileReader entrada=new FileReader("config.txt");
		
			int caracter=0;
			int x=0;
			
			while(caracter!=-1){
				caracter=entrada.read();
				char letras=(char)caracter;
				x++;
				
				if(x>0 && x<5){
					any += letras;
				}
				
				if(x>5 && x<8){
					mes += letras;
				}
				
				if(x>9 && x<13){
					idioma_entrada +=letras;
				}
				if(x>13 && x<17) {
					idioma_salida +=letras;
				}
				if(x>13 && x<17) {
					idioma +=letras;
				}
			}
			Calendar fecha = Calendar.getInstance();
			fecha.setMinimalDaysInFirstWeek(1);
			
			System.out.println("AÑO : " +any);
			System.out.println("MES : " +mes+"\n");
			fecha.set(Integer.parseInt(any), Integer.parseInt(mes)-1, 1);
			
			int semana = fecha.get(Calendar.WEEK_OF_MONTH);
			int xmes = fecha.get(fecha.MONTH)+1;

			numeroSemanasMes = fecha.getActualMaximum(Calendar.WEEK_OF_MONTH);

			primerDiaSemanaMes = fecha.get(Calendar.DAY_OF_WEEK);
			int prim= fecha.getActualMaximum(fecha.DAY_OF_WEEK);
			diaMes = fecha.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			semanaAnyo = fecha.get(Calendar.WEEK_OF_YEAR);
			totalSemanasAnyo = fecha.getWeeksInWeekYear();
		
			entrada.close();

			
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero");
		}

	}
	
	public String dame_any(){
		return any;
	}
	public String dame_mes(){
		return mes;
	}
	public String idioma_entrada(){
		return idioma_entrada;
	}
	public String idioma_salida(){
		return idioma_salida;
	}
	public String dame_idioma(){
		return idioma;
	}
	public int dame_semana(){
		return semana;
	}
	public int numeroSemanasMes(){
		return numeroSemanasMes;
	}
	public int primerDiaSemanaMes(){
		return primerDiaSemanaMes;
	}
	public int diaMes(){
		return diaMes;
	}
	public int semanaAnyo(){
		return semanaAnyo;
	}

}
