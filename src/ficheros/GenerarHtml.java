package ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;



public class GenerarHtml{
	String cad = "";
	
	public void generafichero(LinkedHashMap<String, String> db,String cad) {
		this.cad = cad;
		
		LeerFicheroConfig configuracion = new LeerFicheroConfig();
		
		String idioma = configuracion.dame_idioma();
		String ficheroIdioma = configuracion.idioma_salida();
		
		LeerFicheroIdiomas idiomasalida = new LeerFicheroIdiomas();
		idiomasalida.leeidioma(ficheroIdioma);
		String mesesCabeceraHtml=idiomasalida.mesIdioma();
		String[] textElements1 = mesesCabeceraHtml.split(",");
		
		int mesN = Integer.parseInt(configuracion.dame_mes());
		String mes = textElements1[mesN-1]+" "+ configuracion.dame_any();
		
		String diasCabeceraHtml=idiomasalida.diasidioma();
		String[] textElements = diasCabeceraHtml.split(",");
		
		String generadoCabeceraHtml=idiomasalida.generadoPor();
		String[] textElements2 = generadoCabeceraHtml.split(",");
		
		System.out.println();
		//DatosBase db = new DatosBase(Integer.parseInt(configuracion.dame_mes())-1, Integer.parseInt(configuracion.dame_any()), "Free");
		//db.generaDatosInicial();
		//db.getTablaInicial().forEach((k,v) -> System.out.println("----- Key: " + k + " Value:" + v));
		
		 FileWriter filewriter = null;
		 PrintWriter printw = null;{
		        
		 try{
			 
		     filewriter = new FileWriter(cad+".html");//declarar el archivo
		     printw = new PrintWriter(filewriter);//declarar un impresor
		            
		     printw.println("<html>");
		     printw.println("<head><title>Agenda</title></head>");     

		     printw.println("<body>");

		     printw.println("<center><h1><font color=\"navy\">"+cad+"</font></h1></center>");
		     printw.println("<center><h2><font color=\"navy\">"+mes+"</font></h2></center>");
		     
		     int semanas= 1;
		     int dias=1,diasDatos=1,controlDias=0;
		     int sAnyo=configuracion.semanaAnyo();
		     int primerDia = configuracion.primerDiaSemanaMes()-1;
		     if (primerDia==0) primerDia=7;
		     String claveValor="";
		     
		     String valor="";
		     
		     while(semanas <= configuracion.numeroSemanasMes()) {
    
		    	 // Cabecera semana
			     printw.println("<center><table border=\"1\" width=\"80%\" style=\"text-align:center;"
			     		+ " border-collapse:collapse\"><tr style=\"background-color:#b3e3f5\"><td>"+"Semana " + sAnyo +"</td>");
			     for (int i=0; i<7;i++) {
			    	 printw.println("<td>"+ textElements[i] +"</td>");
			    	 if (i==6)printw.println("</tr>");
				}
			     
			    printw.println("<tr><td style=\"background-color:#daecf3\">"+ "Dia" +"</td>");
			    
			    boolean entra=true,control=true;
			    int controlz=0;
			    
			    // Cabecera dias
			    for(int i=0; i<7; i++) {
			    	 if(semanas == 1 && entra) {
			    		 for(int z=1; z<primerDia;z++){
			    			 printw.println("<td style=\"background-color:#daecf3\">"+" " + "</td>");
			    			 controlz=z;

			    		 }			    		 
			    		 entra=false;
			    		 for(int z=controlz; z<7;z++){
			    			 printw.println("<td style=\"background-color:#daecf3\">"+ dias++ +"</td>");
			    		 }

			    	 }
		    		 if(semanas>1 && control){
		    			 diasDatos=dias;
		    			 control=false;

		    		 } 
			    	 if(dias<=configuracion.diaMes() && semanas>1){
			    		 printw.println("<td style=\"background-color:#daecf3\">"+dias++ + "</td>");
			    		 if(semanas<configuracion.numeroSemanasMes())
			    		 controlDias=dias;

			    	 } else if(semanas>1){
			    		 printw.println("<td style=\"background-color:#daecf3\">"+" " + "</td>");
			    	 }

			     }

			     printw.println("</tr>");
			     int horas = 1;
			     entra=true;
			     controlz=0;
			     for (int i = 0; i < 24; i++) {
			    	 
				     printw.println("<tr><td style=\"background-color:#daecf3\">"+ i + "-" + horas +"</td>");
			    	 if(semanas == 1 && entra) {
			    		 for(int z=1; z<primerDia;z++){
			    			 printw.println("<td>"+" " + "</td>");
			    			 controlz=z;
			    		 }entra=false;
			    		 for(int z=controlz; z<7;z++){
			    			 claveValor=Integer.toString(diasDatos)+"/"+mesN+"/"+configuracion.dame_any()+"_"+i+"-"+horas;
			    			 valor = db.get(claveValor);  //Obtiene valor
			    			/* if(db.getTablaInicial().containsKey(claveValor)){
			    		        } else {
			    		     }*/
			    			 
			    			 printw.println("<td>"+ valor + "</td>");
			    			 diasDatos++;
			    			 
			    		 }if(semanas==1){
			    			 diasDatos=1;
			    		 }
			    		 
			    	 }
			    	 entra=true;
			    	 
	    	 
				    if(semanas>1 && semanas<configuracion.numeroSemanasMes()) {
				    	
			    		 for(int z=1; z<=7;z++){
			    			 claveValor=Integer.toString(diasDatos)+"/"+mesN+"/"+configuracion.dame_any()+"_"+i+"-"+horas;
			    			 valor = db.get(claveValor);  //Obtiene valor 
			    			 printw.println("<td>"+ valor +"</td>");
			    			 diasDatos++;
			    			 controlz=z;
			    		 }
			    		 diasDatos=diasDatos-7;
			    	 }

			    	if(semanas==configuracion.numeroSemanasMes()){

			    		for(int z=controlDias; z<dias;z++){
			    			
			    			 claveValor=Integer.toString(diasDatos)+"/"+mesN+"/"+configuracion.dame_any()+"_"+i+"-"+horas;
			    			 valor = db.get(claveValor);  //Obtiene valor
			    			 printw.println("<td>"+ valor +"</td>");
			    			 diasDatos++;			    			
			    		 }
			    		diasDatos=controlDias;
			    		for(int y=0;y<(7-(dias-controlDias));y++){
			    			printw.println("<td>"+" " + "</td>");
			    		}
			    	 } 

				     horas++;
			     }
			     

			     printw.println("</table></center><br>");
			     
			     semanas++;
			     sAnyo++;
		     }
		     
		     printw.println("<div>" +generadoCabeceraHtml+": " +"</div>");
		     printw.println("</body>");
		     printw.println("</html>");
		     printw.close();
		            
		     System.out.println("Generado exitosamente");

		 } catch (IOException e) {
			 System.out.println("No Funciona");
			 
		 }
		
	}
	 
	}
	

}
