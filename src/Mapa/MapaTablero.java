package Mapa;

public class MapaTablero {
	private static final int FILAS = 4;
	private static final int COLUMNAS = 8;
	private Celda tablero[][];

	public MapaTablero() {
		tablero = new Celda[FILAS][COLUMNAS];
	}

	public void generarTablero() {
		for (int x = 0; x < FILAS; x++) {
			for (int y = 0; y < COLUMNAS; y++) {
				tablero[x][y] = new Celda(x, y);
			}
		}
	}

	public void mostrarTablero(MapaTablero mapa) {
		for (int x = 0; x < FILAS; x++) {
			for (int y = 0; y < COLUMNAS; y++) {
				System.out.println(mapa.tablero[x][y]);
			}
		}
	}
}
