package grafics;

import Mapa.*;
import maps.cuadros.Tiles;

public final class Windows {
	private final int width;
	public Sprite sprites;
	int difTop;
	public int getDifTop() {
		return difTop;
	}


	public int getDifIz() {
		return difIz;
	}
	int difIz;
	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}
	private final int height;
	public final int[] pixeles;

	
	public Windows(final int width, final int height, MapaTablero mapita)
	{
		sprites = new Sprite(32,SpriteSheet.hojaPrueba);
		this.height = height;
		this.width = width;
		pixeles = new int[width * height];
		difIz = width/2 - mapita.getAltoPix();
		difTop = height/2 - mapita.getAnchoPix();
	}

	
	public void guardarMapa (int anchoMapa, int altoMapa, Maps mapa)
	{
		
	}
	public void mostrarCuadro (int compensacionX, int compensacionY, Tiles cuadro) {
		
	}
}
