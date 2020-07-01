package grafics;
/**
 * En este caso, subdivide la SpriteSheet en sprites que puedan ser usados, estos son guardados en un arreglo de pixeles. 
 * 
 * 
 * 
 * @author Matías Di Croce
 *
 */
public class Sprite {
	private final int size; 
	private int x;
	private int y;
	public int[][] pixeles;
	
	public Sprite (final int size, final SpriteSheet hoja) {
		this.size = size;
		int eseQueVaAbajo = hoja.getAncho()/size;
		pixeles = new int [(hoja.getAncho()/size)*(hoja.getAlto()/size)] [size * size];
		this.x = 0 * size;
		this.y = 0 * size;
		for (int i = 0; i<100 ; i++) {
			for (int y = 0; y< size; y++) {
				for (int x = 0; x < size; x++) {
					pixeles[i][x + y * size] = hoja.pixeles [(x+this.x) + (y + this.y) *hoja.getAncho()];
				}
			}
			this.x = (i%eseQueVaAbajo) * size;
			this.y = i/eseQueVaAbajo * size;
		}
		
	}
	public int[] getPixeles(int i) {
		return this.pixeles[i];
	}
	public int getSize () {
		return this.size;
	}
}
