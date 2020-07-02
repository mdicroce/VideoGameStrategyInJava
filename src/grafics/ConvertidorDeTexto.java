package grafics;

/**
 * Clase que convierte cada caracter de un mensaje a un numero que coicide con la posicion de su respectivo Sprite y los pone en un ArrayList.
 * 
 * 
 * @author Nahuel Flores
 *
 */

import java.util.ArrayList;


public class ConvertidorDeTexto {
		
	private String caracteres;
	private int[] texto;
	private String textoString;
	private boolean cursor;

		
	public ConvertidorDeTexto () {
		caracteres = "]abcdefghijklmnopqrstuvwxyz      0123456789.,!?'\"-+=/\\%()<>:;    ";
		cursor = false;
		texto = new int[18];
		
	}

//--------------------------------------GETTERS--------------------------------------------//

	public String getCaracteres() {
		return caracteres;
	}

//--------------------------------------SETTERS--------------------------------------------//
	
	public void setCaracteres(String caracteres) {
		this.caracteres = caracteres;
	}	
	
//--------------------------------------METODOS PROPIOS-------------------------------------//
	
/**
 * Este metodo recorre el String Caracteres para encontrar la posicion del char c y devolver su posicion.
 * 
 * @param c es el caracter a buscar en el String.
 * @return un entero que es la posicion del Sprite correspondiente al caracter.
 * @throws CaracterNoExisteException esto ocurre cuando el caracter buscado no se encuentra en el string Caracteres.
 */
	
	public int buscar(char c) throws CaracterNoExisteException {
		int i = 0;
		Boolean flag = false;
		while (i < caracteres.length() && flag == false) {
			
			if (caracteres.charAt(i)==c) {
				flag = true;
			}
			else {
				i++;	
			}
		}
		if (!flag && c == '\n') {
			return -1;
		}
		if (flag == false) {
			throw new CaracterNoExisteException(c,"El caracter que ingreso no existe");
		}	
		
		return i;
		
	}
	
/**
 * Este metodo recorre el String mensaje y realiza llamadas al metodo buscar para poder convertir el mensaje en un ArrayList con las posiciones de los Sprites de cada caracter. 
 * 	
 * @param mensaje es un String a convertir.
 * @return un ArrayList de int con la misma longitud que el String Mensaje que contiene la posicion de los Sprites para mostrar el menaje requerido.
 */
		
	public ArrayList<Integer> convertirMensaje(String mensaje) {
		int longMensaje = mensaje.length();
		ArrayList<Integer> numSprites = new ArrayList<Integer>();
		int i = 0;

			while (i<longMensaje) {					
					try {
						numSprites.add(i,buscar(mensaje.charAt(i)));
					} catch (CaracterNoExisteException e) {
						System.out.println("Este caracter "+e.getCaracter()+" no existe entre los Sprites");
					}
				i++;
			}
		return numSprites;
	}
	
/**
 * Muestra cada uno de los Sprites que existen con su posicion en el arreglo.
 */
	
	
	public void mostrarCursor () {
		if (this.cursor)
		{
			
		}
	}
	public void actualizar() {
		
	}
		
}

	

