package ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LeerFicheroIdiomas {
	private String diasidioma;
	private String mesIdioma;
	private String generadoPor;
	

	public LeerFicheroIdiomas(String mesIdioma) {
		this.mesIdioma = mesIdioma;
	}

	public LeerFicheroIdiomas() {
		this.diasidioma = "CAT";
	}
	
	public void leeidioma(String fichero){
						
		Map<String,String> mapidiomas = new HashMap<String,String>();
		
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader bf = new BufferedReader(fr);
			String linea="",key,values;

			while((linea = bf.readLine()) != null && !linea.isEmpty()){
				String[] cadenas =linea.split("[;]");

				key = cadenas[0];
				values = cadenas[1];
				
				mapidiomas.put(key, values);
				
				//System.out.println("Clave: " + key + "  Valor: " + values);
			}
			//System.out.println(mapidiomas.get("002"));
			diasidioma=mapidiomas.get("002");
			mesIdioma=mapidiomas.get("004");
			generadoPor=mapidiomas.get("006");
			
			
			//System.out.println(mapidiomas.size() + " Líneas cargadas correctamente");
			fr.close();
	
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero");
		}
		
	}
	public String diasidioma(){
		return diasidioma;
	}
	public String mesIdioma(){
		return mesIdioma;
	}
	public String generadoPor(){
		return generadoPor;
	}


}
