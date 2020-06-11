package maps;

import grafics.Sprite;
import grafics.SpriteSheet;
import grafics.Windows;
import maps.cuadros.Tiles;

public class Maps {
	private int ancho;
	private int alto;
	private Tiles[] cuadritos;
	private int[] tiles;
	
	public Maps (int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		tiles = new int[alto * ancho];
		cuadritos = new Tiles[2];
		cuadritos[0] = new Tiles(Sprite.pastito);
		cuadritos[1] = new Tiles(Sprite.noPastito);
		generarMapa();
	}
	public Maps (String ruta) {
		cargarMapa(ruta);
	}
	public void generarMapa() {
		int i = 0;
		for (int y=0; y<alto ; y++) {
			for (int x = 0; x < ancho; x++)
			{
				tiles[x + y * ancho] = i % 2;
				i++;
			}
		}
	}
	public void cargarMapa(String ruta) {
		
	}
	public void actualizar() {
		
	}
	public void mostrar(int compensacionX, int compensacionY, Windows pantalla, int tiles1, int tiles2) {
		
		
		int o = compensacionX >> 5;
		int es = (compensacionX + pantalla.getWidth()) >> 5;
		int n = compensacionY >> 5;
		int s = (compensacionY + pantalla.getHeight()) >> 5;
		if (es > tiles1) {
			es = tiles1;
		}
		if (s > tiles2) {
			s = tiles2;
		}
		for (int y = n; y < s ; y++) {
			for (int x = o; x < es; x++) {
				getTiles(x,y).mostrar(x, y, pantalla);
			}
		}
	}
	public Tiles getTiles(int x, int y) {
		switch (tiles[x + y * ancho]){
		case 0: 
			return cuadritos[0];
		case 1:
			return cuadritos[1];
			default:
				return cuadritos[1];
		}
			//return Tiles.this.pastito
	}
}
