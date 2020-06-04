package maps;

import grafics.Windows;

public abstract class Maps {
	private int ancho;
	private int alto;
	
	private int[] tiles;
	
	public Maps (int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		tiles = new int[alto * ancho];
		generarMapa();
	}
	public Maps (String ruta) {
		cargarMapa(ruta);
	}
	private void generarMapa() {
		
	}
	private void cargarMapa(String ruta) {
		
	}
	public void actualizar() {
		
	}
	public void mostrar(int compesacionX, int compesacionY, Windows pantalla) {
		
	}
}
