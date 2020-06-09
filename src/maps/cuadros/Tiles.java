package maps.cuadros;

import grafics.Sprite;
import grafics.Windows;

public abstract class Tiles {
	public int x;
	public int y;
	
	public Sprite sprites;
	// Coleccion de cuadros
	public static final Tiles GRASS = new TileGrass(Sprite.pruebita);
	//Fin de la coleccion de cuadros
	
	public Tiles(Sprite sprites) {
		this.sprites = sprites;
	}
	
	public void mostrar (int x, int y, Windows pantalla) {
		pantalla.mostrarCuadro(x,y,this);
	}
}
