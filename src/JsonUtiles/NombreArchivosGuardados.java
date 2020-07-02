package JsonUtiles;

import java.io.File;

public class NombreArchivosGuardados {

	public static String nombreArchivosGuardados(){
		File carpetaFile = new File(sCarpAct);
		String[] listadoStrings = carpetaFile.list();
		
		for (int i = 0; i < listadoStrings.length; i++) {
			System.out.println(listadoStrings[i]);
		}
	}
	
}
