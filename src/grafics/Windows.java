package grafics;

import maps.cuadros.Tiles;

public final class Windows {
	private final int width;
	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}
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

	
	public void mostrar (final int compesacionX, final int compesacionY)
	{
		Sprite[] aux = new Sprite[100];
		int j = 0;
		for (int i = 0; i< 10 ; i++)
		{
			for (int i2 = 0; i2 < 10; i2++) {
				aux[j] = new Sprite(32,i,i2,SpriteSheet.hojaPrueba);
				j++;
			}
		}
		j=0;
		int i = 0;
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
				pixeles[posicionX + posicionY * width] = aux[j].pixeles[(x & MASCARA_SPRITE)+ (y & MASCARA_SPRITE) * LADO_SPRITE];
				i++;
				if (i==32) {
					i=0;
					if (j!=99) {
						j++;
					}
					
				}
				
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
