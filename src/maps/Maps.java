package maps;

import gamePrincipal.GamePruebasPantalla;
import grafics.Sprite;
import grafics.SpriteSheet;
import grafics.Windows;
import maps.cuadros.Tiles;

public class Maps {
	public int getAnchoPix() {
		return anchoPix;
	}
	public int getAltoPix() {
		return altoPix;
	}
	public int getSizeTile() {
		return sizeTile;
	}
	private int anchoPix;
	private int altoPix;
	private int tablero[][];
	private int sizeTile;
	
	public Maps (int ancho, int alto, int sizeTile) {
		this.anchoPix = ancho;
		this.altoPix = alto;
		this.sizeTile = sizeTile;
		tablero = new int[this.altoPix/sizeTile][this.anchoPix/sizeTile];
		generarMapa();
	}
	public Maps (String ruta) {
		cargarMapa(ruta);
	}
	public void generarMapa() {
	}
	public void cargarMapa(String ruta) {
		
	}
	public void actualizar() {
		
	}
	/**
	 * @apiNote Este es el metodo por el cual se dibujan los pixeles del mapa. 
	 * Va a guardar en el arreglo de pixeles del mapa todos los elementos que lo componen, tomando los sprites 
	 * correspondientes a cada Tile.  
	 * @param pantalla: Es la pantalla que se está usando, se tiene que pasar por parámetro para usarse
	 * @param spriteSizePix: Es el tamaño de los sprites en pixeles (size * size)
	 */
	public void mostrar(Windows pantalla, int spriteSizePix) {
		int[] pixelesAux = new int [spriteSizePix];
		for (int i = 0; i<(altoPix/sizeTile);i++) {
			for (int j = 0; j<(anchoPix/sizeTile);j++) {
				pixelesAux = pantalla.sprites.getPixeles(tablero[i][j]);
				for (int y = sizeTile*i; y < altoPix; y++) {
					for (int x = sizeTile * j; x < anchoPix; x ++) {
						pantalla.pixeles[(x+pantalla.getDifIz()) + (y+pantalla.getDifTop()) * anchoPix] = pixelesAux[x + y * pantalla.sprites.getSize()];
					}
				}
			}
		}
		
	}
}
