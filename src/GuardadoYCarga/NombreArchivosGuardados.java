package GuardadoYCarga;

import java.io.File;
import java.util.ArrayList;

public class NombreArchivosGuardados {

	public static ArrayList<String> nombreArchivosGuardados(){
		
		File carpetaFile = new File(System.getProperty("user.dir"));
		String listadoStrings[] = carpetaFile.list();
		ArrayList<String> partidasGuardadas = new ArrayList<String>();
		
		for (int i = 0; i < listadoStrings.length; i++) {
				
			if (listadoStrings[i].charAt(0)=='P'||listadoStrings[i].charAt(1)=='G') {
				partidasGuardadas.add(listadoStrings[i]);
			}
		}

	
		return partidasGuardadas;
	}
	
}
