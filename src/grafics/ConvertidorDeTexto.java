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

		
	public ConvertidorDeTexto () {
		caracteres = "]abcdefghijklmnopqrstuvwxyz      0123456789.,!?'\"-+=/\\%()<>:;    ";
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
	private void dibujarCuadro(Windows pantalla) {
		for (int x = pantalla.getWidth()-28*8; x < pantalla.getWidth()-4*8;x++) {
			for (int y = pantalla.difTop-10*8;y < pantalla.getHeight()+10*8-pantalla.difTop;y++) {
				pantalla.pixeles[x+y*pantalla.getWidth()]=-0;
				if ((x == pantalla.getWidth()-28*8)||(y == pantalla.difTop-10*8) || (x == (pantalla.getWidth()-4*8)-1) || (y==(pantalla.getHeight()+10*8-pantalla.difTop)-1)) {
					pantalla.pixeles[x+y*pantalla.getWidth()] = -1;
				}
				
			}
		}
	}
	public void mostrar(Windows pantalla,String mensaje) {
		dibujarCuadro(pantalla);
		int inicioDeTexto = 8;
		int [] tipoAux;
		int i2 = 1;
		ArrayList<Integer> letrasArrayList = convertirMensaje(mensaje);
		for (int i = 0; i < letrasArrayList.size();i++,i2++) {
			
			int x2=-1,y2=-1;
			if (letrasArrayList.get(i) != -1) {
				tipoAux = pantalla.tipoSprite.getPixeles(letrasArrayList.get(i));
				for (int x = pantalla.getWidth()-(27-i2)*8; x < pantalla.getWidth()-(26-i2)*8;x++) {
					x2++;
					for(int y = pantalla.difTop-inicioDeTexto*8;y<pantalla.difTop-(inicioDeTexto-1)*8;y++) {
						y2++;
						pantalla.pixeles[x+y*pantalla.getWidth()]=tipoAux[(x2%8)+(y2%8)*8];
					}
				}
			}
			else {
				inicioDeTexto--;
				i2=-1;
			}

		}
		
	}
	public void actualizar() {
		
	}
		
}

	

