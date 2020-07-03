package grafics;

import java.util.ArrayList;

import gamePrincipal.GameController;
import gamePrincipal.GameMain;
import mensajes.Textos;

public class CuadroTextoG {
	private ConvertidorDeTexto textosAMostrar;
	private ArrayList<String> textArray;
	public byte selected;
	private boolean isSeleccionable;
	private Textos textoActual;
	public int tipoDeOpcion;
	public CuadroTextoG(Textos textoNuevo) {
		textosAMostrar = new ConvertidorDeTexto();
		textArray = new ArrayList<String>();
		selected = 0;
		isSeleccionable = false;
		textoActual = textoNuevo;
		textoNuevo.cargaDeMensajes(this);
	}
	
	public void cargarMensajes(String mensaje) {
		if (textArray.size() <=14) {
			textArray.add(mensaje);
		}
	}
	public void dibujarCuadro(Windows pantalla) {
		for (int x = pantalla.getWidth()-28*8; x < pantalla.getWidth()-4*8;x++) {
			for (int y = pantalla.difTop-10*8;y < pantalla.getHeight()+10*8-pantalla.difTop;y++) {
				pantalla.pixeles[x+y*pantalla.getWidth()]=-0;
				if ((x == pantalla.getWidth()-28*8)||(y == pantalla.difTop-10*8) || (x == (pantalla.getWidth()-4*8)-1) || (y==(pantalla.getHeight()+10*8-pantalla.difTop)-1)) {
					pantalla.pixeles[x+y*pantalla.getWidth()] = -1;
				}
				
			}
		}
	}
	public void setSeleccionable(boolean isSeleccionable) {
		this.isSeleccionable = isSeleccionable;
	}

	public void dejarDeMostrar() {
		textArray.clear();
	}
	public void mostrar(Windows pantalla) {
		dibujarCuadro(pantalla);
		
		int [] tipoAux;
		if (!isSeleccionable) {
			for (int j = 0; j<textArray.size();j++) {
				ArrayList<Integer> letrasArrayList = textosAMostrar.convertirMensaje(textArray.get(j));
				for (int i = 0, i2 = 0; i < letrasArrayList.size();i++,i2++) {
					int inicioDeTexto = 8-j*4;
					if (i%20 == 19) {
						inicioDeTexto--;
						i2=0;
					}
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
						i2=0;
					}
	
				}
			}
		}
		else {
			for (int j = 0; j<textArray.size();j++) {
				ArrayList<Integer> letrasArrayList = textosAMostrar.convertirMensaje(textArray.get(j));
				
				if (selected == j) {
					int auxiliar = textosAMostrar.convertirMensaje(">").get(0);
					
					int inicioDeTexto = 8-j*4;
					int x2=-1, y2=-1;
					tipoAux = pantalla.tipoSprite.getPixeles(auxiliar);
					for (int x = pantalla.getWidth()-(28-1)*8; x < pantalla.getWidth()-(27-1)*8;x++) {
						x2++;
						for(int y = pantalla.difTop-inicioDeTexto*8;y<pantalla.difTop-(inicioDeTexto-1)*8;y++) {
							y2++;
							pantalla.pixeles[x+y*pantalla.getWidth()]=tipoAux[(x2%8)+(y2%8)*8];
						}
					}
				}
				for (int i = 0, i2 = 0; i < letrasArrayList.size();i++,i2++) {
					int inicioDeTexto = 8-j*4;
					if (i%20 == 19) {
						inicioDeTexto--;
						i2=1;
					}
					int x2=-1,y2=-1;
					if (letrasArrayList.get(i) != -1) {
						tipoAux = pantalla.tipoSprite.getPixeles(letrasArrayList.get(i));
						for (int x = pantalla.getWidth()-(26-i2)*8; x < pantalla.getWidth()-(25-i2)*8;x++) {
							x2++;
							for(int y = pantalla.difTop-inicioDeTexto*8;y<pantalla.difTop-(inicioDeTexto-1)*8;y++) {
								y2++;
								pantalla.pixeles[x+y*pantalla.getWidth()]=tipoAux[(x2%8)+(y2%8)*8];
							}
						}
					}
					else {
						inicioDeTexto--;
						i2=1;
					}
	
				}
			}
		}
		
	}
	public byte getSelected() {
		return selected;
	}
	public boolean actualizar(GameController teclado) {
		teclado.actualizar();
		if (teclado.arriba) {
			
			if (selected > 0)
			{
				try {
					selected--;
					Thread.sleep(200);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (teclado.abajo) {
			
			if (selected < textArray.size()-1) {
				try {
					selected++;
					Thread.sleep(200);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		else if (teclado.enter) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			teclado.enter = false;
			return true;
		}
		return false;
	}
	
}
