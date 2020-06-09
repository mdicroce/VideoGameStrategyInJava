package grafics;

import maps.cuadros.Tiles;

public final class Windows {
	private final int width;
	private final int height;
	public final int[] pixeles;
	
	//temporal
	private final static int LADO_SPRITE = 32;
	private final static int MASCARA_SPRITE = LADO_SPRITE -1;
	//fin del temporal
	
	public Windows(final int width, final int height)
	{
		
		this.height = height;
		this.width = width;
		pixeles = new int[width * height];
	}
	public void limpiar () {
		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}
	
	public void mostrar (final int compesacionX, final int compesacionY)
	{
		for (int y = 0; y<height; y++)
		{
			int posicionY = y + compesacionY;
			if (posicionY < 0 || posicionY >= height) {
				continue;
			}
			for (int x = 0; x < width; x++)
			{
				int posicionX = x + compesacionX;
				if (posicionX < 0 || posicionX >= width) {
					continue;
				}
				// despues veremos como se hace
				pixeles[posicionX + posicionY * width] = Sprite.pruebita.pixeles[(x & MASCARA_SPRITE)+ (y & MASCARA_SPRITE) * LADO_SPRITE]; 
			}
		}
	}
	public void mostrarCuadro (int compensacionX, int compensacionY, Tiles cuadro) {
		for (int y = 0; y < cuadro.sprites.getSize() ; y++) {
			int posicionY = y + compensacionY;
			for (int x = 0; x < cuadro.sprites.getSize(); x++) {
				int posicionX =  x + compensacionX;
				if (posicionX < 0 || posicionX > width || posicionY < 0 || posicionY > height) {
					break;
				}
				pixeles[posicionX + posicionY * width] = cuadro.sprites.pixeles[x + y * cuadro.sprites.getSize()];
			}
		}
	}
}
