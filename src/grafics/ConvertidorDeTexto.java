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

		
	public ConvertidorDeTexto () {
		caracteres = "abcdefghijklmnopqrstuvwxyz 0123456789.,!?'\"-+=/\\%()<>:;";
		}
		
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
		
		if (flag == false) {
			throw new CaracterNoExisteException(c,"El caracter que ingreso no existe");
		}	
		
		return i;
		
	}
		
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
		
		public void mostrar() {
			int i = 0;
			while (i<caracteres.length()) {
				
				System.out.println(i+" --> "+caracteres.charAt(i));
				i++;
			}
		}
		
	}

	

