package grafics;

import Jugadores.Jugador;
import Mapa.Celda;
import Mapa.MapaTablero;
import gamePrincipal.GameController;
import gamePrincipal.GameMain;
import gamePrincipal.PantallaOpciones;
import mensajes.Textos;
import mensajes.apuntaAlVacio;
import mensajes.apuntaPersonajeAliado;
import mensajes.apuntaPersonajeEnemigo;

public class Cursor {
	public int posicionX;
	public int posicionY;
	private int limiteTOP;
	private int limiteBOT;
	private int limiteIZ;
	private int limiteDER;
	public int[] pixels;
	public Jugador player;
	public int posicionYaux;
	public int posicionXaux;
	
	public Cursor(Windows pantalla, MapaTablero mapita) {
		posicionY = pantalla.difTop;
		posicionX = pantalla.difIz;
		this.posicionXaux = posicionX;
		this.posicionYaux = posicionY;
		this.limiteIZ = pantalla.difIz;
		this.limiteTOP = pantalla.difTop;
		this.limiteBOT = pantalla.difTop + mapita.getAltoPix()-32;
		this.limiteDER = pantalla.difIz + mapita.getAnchoPix()-32;
		pixels = new int [pantalla.sprites.getSize()];
		pixels = pantalla.sprites.getPixeles(21);
	}
	
	public void mostrar(Windows pantalla) {
		int x2 = -1,  y2=-1;
		for (int x = posicionX;x<posicionX+32;x++) {
			x2++;
			for(int y = posicionY;y<posicionY+32;y++) {
			y2++;
				if (pixels[(x2%32)+ (y2%32) *32] != -16711936) {
				pantalla.pixeles[x+y*pantalla.getWidth()] = pixels[(x2%32)+ (y2%32) *32];
				}
			}
		}
		
	}
	public void setJugador(Jugador jugadorActual) {
		this.player = jugadorActual;
	}
	public void actualizar(GameController teclado, MapaTablero mapita) {
		teclado.actualizar();
		if (teclado.arriba) {
			if(this.limiteTOP < this.posicionY) {
				try {
					this.posicionY -= 32;
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (teclado.abajo)
		{
			if(this.limiteBOT > this.posicionY) {
				try {
					Thread.sleep(100);
					this.posicionY+= 32;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		else if (teclado.derecha)
		{
			if(this.limiteDER>this.posicionX) {
				try {
					this.posicionX+=32;
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else if (teclado.izquierda)
		{
			if (this.limiteIZ<this.posicionX) {
				try {
					this.posicionX-=32;
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else if(teclado.enter)
		{
			
			if (mapita.getTablero()[(posicionX-posicionXaux)/32][(posicionY-posicionYaux)/32].getOcupado()) {
				if(mapita.getTablero()[(posicionX-posicionXaux)/32][(posicionY-posicionYaux)/32].getUnidad().getPropiedad()==this.player.getIdPlayer())
				{
					GameMain.textoG = new CuadroTextoG(new apuntaPersonajeAliado(this.player, teclado));
				}
				else
				{
					GameMain.textoG = new CuadroTextoG(new apuntaPersonajeEnemigo(this.player, teclado));
				}
			}
			else
			{
				GameMain.textoG = new CuadroTextoG(new apuntaAlVacio(this.player, teclado));
				GameMain.textoG.setSeleccionable(true);
			}
		}
	}
	public Celda actualizar(GameController teclado, MapaTablero mapa, int fefe) {
		teclado.actualizar();
		if (teclado.arriba) {
			if(this.limiteTOP < this.posicionY) {
				try {
					this.posicionY -= 32;
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (teclado.abajo)
		{
			if(this.limiteBOT > this.posicionY) {
				try {
					Thread.sleep(100);
					this.posicionY+= 32;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		else if (teclado.derecha)
		{
			if(this.limiteDER>this.posicionX) {
				try {
					this.posicionX+=32;
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else if (teclado.izquierda)
		{
			if (this.limiteIZ<this.posicionX) {
				try {
					this.posicionX-=32;
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else if(teclado.enter)
		{
			
			if (mapa.getTablero()[(posicionX-posicionXaux)/32][(posicionY-posicionYaux)/32].getOcupado()) {
				return null;
			}
			else
			{
				return mapa.getTablero()[(posicionX-posicionXaux)/32][(posicionY-posicionYaux)/32];
			}
		}
		return null;
	}
}
