package grafics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private final int ancho;
	private final int alto;
	public final int[] pixeles;
	//Colecciones de hojas de sprites
	public static SpriteSheet hojaPrueba = new SpriteSheet("/Textures/Finales.png",320,320);
	public static SpriteSheet hojaTipos = new SpriteSheet("/Textures/icons.png", 256, 256);
	//Fin de la coleccion
	
	public SpriteSheet (final String ruta, final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		pixeles = new int[ancho*alto];
		try {
			BufferedImage imagen = ImageIO.read(SpriteSheet.class.getResource(ruta));
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getAncho() {
		return this.ancho;
	}
	public int getAlto() {
		return this.alto;
	}
	
}
