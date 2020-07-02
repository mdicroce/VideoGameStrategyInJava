package JsonUtiles;

import java.io.File;

public class NombreArchivosGuardados {

	public static String[] nombreArchivosGuardados(){
		File carpetaFile = new File(System.getProperty("user.dir"));
		String[] listadoStrings = carpetaFile.list();
		if (listadoStrings==null|| listadoStrings.length == 0) {
			System.out.println("No Bro");
		}
		else {
			for (int i = 0; i < listadoStrings.length; i++) {
				System.out.println(listadoStrings[i]);
			}
		}
		
		return listadoStrings;
	}
	
}
