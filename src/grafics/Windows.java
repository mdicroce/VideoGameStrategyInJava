package grafics;

import Mapa.*;
import maps.cuadros.Tiles;

public final class Windows {
	private final int width;
	public Sprite sprites;
	public Sprite tipoSprite;
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
	public final int[][]pixelesAux;

	
	public Windows(final int width, final int height, MapaTablero mapita)
	{
		sprites = new Sprite(32,SpriteSheet.hojaPrueba);
		tipoSprite = new Sprite(8, SpriteSheet.hojaTipos);
		this.height = height;
		this.width = width;
		pixeles = new int[width * height];
		pixelesAux = new int [height][width];
		difIz = width/2 - mapita.getAltoPix()/2;
		difTop = height/2 - mapita.getAnchoPix()/2;
	}

	public void guardarMapa (int anchoMapa, int altoMapa, MapaTablero mapa)
	{
		
	}
	public void mostrarCuadro (int compensacionX, int compensacionY, Tiles cuadro) {
		
	}
}
