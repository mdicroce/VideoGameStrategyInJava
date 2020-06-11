package grafics;
/**
 * Size representa cuantos pixeles tendrá el sprite. puede ser 32x32, 16x16
 * pixeles guarda todos los pixeles que tendrá el sprite
 * En la spriteSheet tiene varias sprites, lo cual se seleccionara a través de su coordenada. Ejemplo: fila 1 - columna 5 o fila 0 columna 2.
 * 
 * @author Matías Di Croce
 *
 */
public class Sprite {
	private final int size; 
	private int x;
	private int y;
	public int[] pixeles;
	private SpriteSheet hoja;
	//coleccion de sprites
	public static Sprite pastito = new Sprite(32,0,0,SpriteSheet.hojaPrueba);
	public static Sprite noPastito = new Sprite(32,1,0,SpriteSheet.hojaPrueba);
	//fin de la coleccion
	
	public Sprite (final int size, final int column, final int fila, final SpriteSheet hoja) {
		this.size = size;
		pixeles = new int [size * size];
		this.x = column * size;
		this.y = fila * size;
		this.hoja = hoja;
		for (int y = 0; y< size; y++) {
			for (int x = 0; x < size; x++) {
				pixeles[x + y * size] = hoja.pixeles [(x+this.x) + (y + this.y) *hoja.getAncho()];
			}
		}
	}
	public int getSize () {
		return this.size;
	}
}
