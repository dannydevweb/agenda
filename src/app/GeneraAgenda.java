package app;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import ficheros.LeerFicheroConfig;

public class GeneraAgenda {

	public static void main(String[] args) {
		LeerFicheroConfig configuracion = new LeerFicheroConfig();
		configuracion.leerfileconfig();
		
		System.out.println("Año: " + configuracion.dame_any());
		System.out.println("Mes: " + configuracion.dame_mes());
		System.out.println("Fichero idioma de entrada: " + configuracion.idioma_entrada());
		System.out.println("Fichero idioma de salida: " + configuracion.idioma_salida());
		//GregorianCalendar
		Calendar fecha = Calendar.getInstance();
		//fecha.set(configuracion.dame_any(), configuracion.dame_mes(), 15);
		fecha.setFirstDayOfWeek(Calendar.MONDAY);
		fecha.setMinimalDaysInFirstWeek(1);
		fecha.set(2019, 4, 1);
		//Date date = new Date();
		//fecha.setTime(date);
		
		
		
//		System.out.println(fecha.getTime());
//		System.out.println(fecha.getClass());
		System.out.println("Numero semanas en un año: " + fecha.getWeeksInWeekYear());
		System.out.println("Semanas del mes: " + fecha.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Semana del año: " + fecha.get(Calendar.WEEK_OF_YEAR));
		
		System.out.println("Dia de la semana //Día 4 = WEDNESDAY = MIÉRCOLES" + fecha.get(Calendar.DAY_OF_WEEK));
		System.out.println(" " + fecha.get(Calendar.DATE));
		System.out.println("Dias semanas en mes " + fecha.getActualMaximum(fecha.WEEK_OF_MONTH));
		System.out.println("Dias del mes " + fecha.getActualMaximum(fecha.DAY_OF_MONTH));
		
/*		 while (year >= cal.get(Calendar.YEAR)) {
		        cal.add(Calendar.DAY_OF_MONTH, 7);
		        System.out.println(sdf.format(cal.getTime()));
		 }*/
		
		
		
		
		
		
		
		
//		Map<String,String> mapagenda = new HashMap<String,String>();
		
		String matrix[][] = new String[10][24];
		matrix[0][0]=configuracion.dame_mes();
		matrix[0][1]=configuracion.dame_mes();
		matrix[0][2]=configuracion.dame_mes();
		matrix[0][3]=configuracion.dame_mes();
		matrix[0][4]=configuracion.dame_mes();
		matrix[0][5]=configuracion.dame_mes();
		matrix[0][6]=configuracion.dame_mes();
		matrix[0][7]=configuracion.dame_mes();
		matrix[0][8]=configuracion.dame_mes();
		matrix[0][9]=configuracion.dame_mes();
		matrix[0][10]=configuracion.dame_mes();
		matrix[0][11]=configuracion.dame_mes();
		matrix[0][12]=configuracion.dame_mes();
		matrix[0][13]=configuracion.dame_mes();
		matrix[0][14]=configuracion.dame_mes();
		matrix[0][15]=configuracion.dame_mes();
		matrix[0][16]=configuracion.dame_mes();
		matrix[0][17]=configuracion.dame_mes();
		matrix[0][18]=configuracion.dame_mes();
		matrix[0][19]=configuracion.dame_mes();
		matrix[0][20]=configuracion.dame_mes();
		matrix[0][21]=configuracion.dame_mes();
		matrix[0][22]=configuracion.dame_mes();
		matrix[0][23]=configuracion.dame_mes();
		

		matrix[1][0]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][1]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][2]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][3]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][4]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][5]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][6]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][7]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][8]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][9]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][10]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][11]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][12]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][13]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][14]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][15]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][16]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][17]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][18]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][19]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][20]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][21]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][22]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		matrix[1][23]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
		
		matrix[2][0]="0-1";
		/*		matrix[2][1]="1-2";
		matrix[2][2]="2-3";
		matrix[2][3]="3-4";
		matrix[2][4]="4-5";
		matrix[2][5]="5-6";
		matrix[2][6]="6-7";
		matrix[2][7]="7-8";
		matrix[2][8]="8-9";
		matrix[2][9]="9-10";
		matrix[2][10]="10-11";
		matrix[2][11]="10-11";
		matrix[2][12]="11-12";
		matrix[2][13]="13-12";
		matrix[2][14]="14-15";
		matrix[2][15]="15-16";
		matrix[2][16]="16-17";
		matrix[2][17]="17-18";
		matrix[2][18]="18-19";
		matrix[2][19]="19-20";
		matrix[2][20]="20-21";
		matrix[2][21]="21-22";
		matrix[2][22]="22-23";
		matrix[2][23]="23-24";*/
		
		//System.out.println(matrix[0][0]);
		int lin=0;
		for(int i=0;i<10;i++){
			
			if (lin==0){
			for(int z=0; z<24; z++){
				matrix[i][z]=configuracion.dame_mes();
				lin++;
			}
			if (lin==1){
				for(int z=0; z<24; z++){
					matrix[i][z]=String.valueOf((fecha.get(Calendar.WEEK_OF_MONTH)));
					lin++;
				}
			}
			if (lin==2){
				int a = 0;int b = 0;
				for(int z=0; z<24; z++){
					matrix[i][z]=(a+"-"+b);
					System.out.println("Suma: " + a+b);
					b++;
					lin++;
				}
			}
			
			}
		}

		
		for(int i=0;i<10;i++){
			System.out.println();
			for(int z=0; z<24; z++){
				System.out.print(matrix[i][z]+" ");
			}
				
		}
		
		

	}

}

