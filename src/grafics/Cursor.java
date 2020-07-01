package grafics;

import Mapa.MapaTablero;

public class Cursor {
	private int posicionX;
	private int posicionY;
	private int limiteTOP;
	private int limiteBOT;
	private int limiteIZ;
	private int limiteDER;
	public int[] pixels;
	
	public Cursor(Windows pantalla, MapaTablero mapita) {
		posicionY = pantalla.difTop+(mapita.getAltoPix()/2);
		posicionX = pantalla.difIz+(mapita.getAnchoPix()/2);
		this.limiteIZ = pantalla.difIz;
		this.limiteTOP = pantalla.difTop;
		this.limiteBOT = pantalla.difTop + mapita.getAltoPix();
		this.limiteDER = pantalla.difIz + mapita.getAnchoPix();
		pixels = new int [pantalla.sprites.getSize()];
		pixels = pantalla.sprites.getPixeles(21);
	}
	public void mostrar(Windows pantalla) {
		int x2 = -1,  y2=-1;
		for (int x = posicionX;x<posicionX+32;x++) {
			x2++;
			System.out.println("");
			for(int y = posicionY;y<posicionY+32;y++) {
			y2++;
				if (pixels[(x2%32)+ (y2%32) *32] != -16711936) {
				pantalla.pixeles[x+y*pantalla.getWidth()] = pixels[(x2%32)+ (y2%32) *32];
				}
			}
		}
	}
	public void actualizar() {
		
	}
}
