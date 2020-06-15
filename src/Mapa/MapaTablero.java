package Mapa;

import Unidades.Caballero;
import Unidades.Unidad;

public class MapaTablero {
	private static final int FILAS = 4;
	private static final int COLUMNAS = 8;
	private Celda tablero[][];

	public MapaTablero() {
		tablero = new Celda[FILAS][COLUMNAS];
	}

	// -----------------------------------------------------//

	public void generarTablero() {
		for (int x = 0; x < FILAS; x++) {
			for (int y = 0; y < COLUMNAS; y++) {
				tablero[x][y] = new Celda(x, y);
			}
		}
	}

	public void insertarUnidadTablero(Unidad unidad, Celda celda) {
		celda.setUnidad(unidad); // INSERTO LA UNIDAD EN LA CELDA
		celda.setOcupado(true); // LA CELDA PASA A ESTAR OCUPADA
		unidad.setPosicion(celda); // LE ASIGNO LA NUEVA POSICION A LA UNIDAD
	}

	public void moverUnidadTablero(Unidad unidad, Celda posActual, Celda destino) {
		posActual.quitarUnidadCelda(posActual); // QUITO LA UNIDAD DE LA CELDA EN LA QUE ESTA
		if (destino.getOcupado() == true) // SI QUIERE MOVERSE A UNA CELDA QUE ESTA OCUPADA POR UNA PIEZA ENEMIGA
		{
			if (destino.getUnidadCelda().getPropiedad() != posActual.getUnidadCelda().getPropiedad()) {
				unidad.atacar(unidad, destino.getUnidadCelda());
			}
		}
		if (validarMovimiento(unidad, posActual, destino) == true) // VERIFICO SI EL MOVIMIENTO ES VALIDO
		{
			insertarUnidadTablero(unidad, destino); // LA INSERTO EN EL DESTINO
		}
	}

	public boolean validarMovimiento(Unidad unidad, Celda posActual, Celda destino) // EN CASO DE RETORNAR TRUE, EL
																					// MOVIMIENTO ES VALIDO
	{
		boolean bandera = false;

		// PRIMERO VAMOS CON QUE NO PUEDE MOVERSE MAS DE UNA CELDA (EXCEPTO QUE SEA
		// CABALLERO)
		if (Math.abs(posActual.getPosX() - destino.getPosX()) == 1) {
			if (Math.abs(posActual.getPosY() - destino.getPosY()) == 1) {
				bandera = true;
			}
		}
		if (unidad instanceof Caballero) { // excepcion caballero
			if (Math.abs(posActual.getPosX() - destino.getPosX()) <= 2) {
				if (Math.abs(posActual.getPosY() - destino.getPosY()) <= 2) {
					bandera = true;
				}
			}
		}

		// NO PUEDE SUPERAR LOS LIMITES DEL MAPA
		if (destino.getPosX() >= 0 && destino.getPosX() <= 7) {
			if (destino.getPosY() >= 0 && destino.getPosY() <= 3) {
				bandera = true;
			}
		}

		// NO PUEDE MOVERSE A UNA UNIDAD QUE ESTA OCUPADA
		if (destino.getOcupado() == false) {
			bandera = true;
		}

		return bandera;
	}

	public void mostrarTablero(MapaTablero mapa) {
		for (int x = 0; x < FILAS; x++) {
			for (int y = 0; y < COLUMNAS; y++) {
				System.out.println(mapa.tablero[x][y]);
			}
		}
	}
}
