package GuardadoYCarga;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;

public class JsonUtiles 
{
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
