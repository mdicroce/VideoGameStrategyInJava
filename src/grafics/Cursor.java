package grafics;

import Jugadores.Jugador;
import Mapa.MapaTablero;
import gamePrincipal.GameController;

public class Cursor {
	private int posicionX;
	private int posicionY;
	private int limiteTOP;
	private int limiteBOT;
	private int limiteIZ;
	private int limiteDER;
	public int[] pixels;
	public Jugador player;
	
	public Cursor(Windows pantalla, MapaTablero mapita) {
		posicionY = (pantalla.difTop+(mapita.getAltoPix()/2))/32;
		posicionX = (pantalla.difIz+(mapita.getAnchoPix()/2))/32;
		this.limiteIZ = pantalla.difIz/32;
		this.limiteTOP = pantalla.difTop/32;
		this.limiteBOT = (pantalla.difTop + mapita.getAltoPix())/32;
		this.limiteDER = (pantalla.difIz + mapita.getAnchoPix())/32;
		pixels = new int [pantalla.sprites.getSize()];
		pixels = pantalla.sprites.getPixeles(21);
	}
	
	public void mostrar(Windows pantalla) {
		int x2 = -1,  y2=-1;
		
		for (int x = posicionX*32;x<posicionX*32+32;x++) {
			x2++;
			for(int y = posicionY*32;y<posicionY*32+32;y++) {
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
		if (teclado.arriba) {
			if(this.limiteTOP < this.posicionY)
			this.posicionY--;
		}
		else if (teclado.abajo)
		{
			if(this.limiteBOT > this.posicionY)
			this.posicionY++;
		}
		else if (teclado.derecha)
		{
			if(this.limiteDER>this.posicionX)
			this.posicionX++;
		}
		else if (teclado.izquierda)
		{
			if (this.limiteIZ<this.posicionX)
			this.posicionY++;
		}
		else if(teclado.enter)
		{
			if (mapita.getTablero()[posicionX][posicionY].getOcupado()) {
				if(mapita.getTablero()[posicionX][posicionY].getUnidad().getPropiedad()==this.player.getIdPlayer())
				{
					
				}
				else
				{
					
				}
			}
			else
			{
				
			}
		}
	}
}
