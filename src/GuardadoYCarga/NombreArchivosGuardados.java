package GuardadoYCarga;

import java.io.File;
import java.util.ArrayList;

/**
 * En esta clase se puede leer el directorio y levantar los nombres de las partidas guardadas.
 * @author Nahue 
 *
 */

public class NombreArchivosGuardados {

	/**
	 * Lee el directorio y pone los nombres de las partidas guardadas en el ArrayList que luego retorna.
	 * @return Un ArrayList de Strings con los nombres de las partidas guardadas.
	 */
	public static ArrayList<String> nombreArchivosGuardados(){
		
		File carpetaFile = new File(System.getProperty("user.dir"));
		String listadoStrings[] = carpetaFile.list();
		ArrayList<String> partidasGuardadas = new ArrayList<String>();
		
		for (int i = 0; i < listadoStrings.length; i++) {
				
			if (listadoStrings[i].charAt(0)=='P'& listadoStrings[i].charAt(1)=='G') {
				partidasGuardadas.add(listadoStrings[i]);
			}
		}

	
		return partidasGuardadas;
	}
	
}
