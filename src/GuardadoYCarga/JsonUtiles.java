package GuardadoYCarga;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;


/**
 * En esta clase se puede Grabar y Leer.
 * @author Gonzalo Benoffi
 *
 */
public class JsonUtiles 
{
	/**
	 * Graba el JSONArray en un archivo con la direccion pasada por parametro.
	 * @param array JSONArray a grabar.
	 * @param nombreArchi String con el nombre con el que se guardara el archivo.
	 */
	public static void grabar(JSONArray array,String nombreArchi) {
		try {
			FileWriter file = new FileWriter(nombreArchi);
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lee el arcivo y retorna un string que representa un JSON.
	 * @param nombreArchi String con el nombre del archivo a leer.
	 * @return String que luego se usara para construir el JSON.
	 */
	public static String leer(String nombreArchi) 
	{
		String contenido = "";
		try 
		{
			contenido = new String(Files.readAllBytes(Paths.get(nombreArchi)));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return contenido;
	}
}
