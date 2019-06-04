package operaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ServicioDiasPeticion {

		public static  ArrayList<String> generarArrayDias(String mascaraDias) {

			String[] array = mascaraDias.split("");
			ArrayList<String> arrayDiasPeticion = new ArrayList<>();
		
			for (int i = 0; i < array.length; i++) {
				arrayDiasPeticion.add(array[i]);
			}
			return arrayDiasPeticion;
		}
		
		public static ArrayList<Integer> generarArrayDiaNumero(String mascaraDias, String idioma) {
			
			ArrayList<String> dias = generarArrayDias(mascaraDias);
			
			HashMap<String, Integer> cat = new HashMap<>(); //LMCJVSG 
			cat.put("G", 1);
			cat.put("L", 2);
			cat.put("M", 3);
			cat.put("C", 4);
			cat.put("J", 5);
			cat.put("V", 6);
			cat.put("S", 7);
			
			HashMap<String, Integer> eng = new HashMap<>(); //MTWRFSU 
			eng.put("U", 1);
			eng.put("M", 2);
			eng.put("T", 3);
			eng.put("W", 4);
			eng.put("R", 5);
			eng.put("F", 6);
			eng.put("S", 7);
			
			HashMap<String, Integer> esp = new HashMap<>(); //LMXJVSD 
			esp.put("D", 1);
			esp.put("L", 2);
			esp.put("M", 3);
			esp.put("X", 4);
			esp.put("J", 5);
			esp.put("V", 6);
			esp.put("S", 7);
			
			Integer[] diaNum = new Integer[dias.size()];
			Object[] diasNum = dias.toArray();
			
			switch (idioma) {
			case "CAT":
				for (int i = 0; i < dias.size(); i++) {
					diaNum[i] = cat.get(diasNum[i]);
					//System.out.println(diaNum[i]);
				}
				break;
			case "ENG":
				for (int i = 0; i < dias.size(); i++) {
					diaNum[i] = eng.get(diasNum[i]);
					//System.out.println(diaNum[i]);

				}
				break;
			case "ESP":
				for (int i = 0; i < dias.size(); i++) {
					diaNum[i] = esp.get(diasNum[i]);
					//System.out.println(diaNum[i]);

				}
				break;
			}
	
			ArrayList<Integer> diasNumero = new ArrayList<Integer>(Arrays.asList(diaNum));

			return diasNumero;
		}
}
