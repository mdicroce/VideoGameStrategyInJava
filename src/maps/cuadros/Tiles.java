package maps.cuadros;

import grafics.Sprite;
import grafics.SpriteSheet;
import grafics.Windows;

public class Tiles {
	public int x;
	public int y;
	
	public Sprite sprites;
	// Coleccion de cuadros
	//Fin de la coleccion de cuadros
	
	public Tiles(Sprite sprites) {
		this.sprites = sprites;
	}
	
	public void mostrar (int x, int y, Windows pantalla) {
		pantalla.mostrarCuadro(x << 5 ,y << 5,this);
	}
}
