package maps.cuadros;

import Unidades.Unidad;

public class Celda { // PONGO LA CLASE CELDA SOLO PARA QUE VEAN UN POCO LO QUE HABIA HECHO, DESPUES
						// ME ADAPTO A LO QUE HIZO MATIAS
	private int posX;
	private int posY;
	private boolean ocupado;
	private Unidad unidad;

	public Celda(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		ocupado = false;
		unidad = null;
	}

	// ---------------------------METODOSPROPIOS------------------------------//

	public void colocarUnidadTablero(Unidad unidad, Celda posicion) {
		unidad.mover(unidad, posicion);
		ocupado = true;
		this.unidad = unidad;
	}

	public void quitarUnidadCelda(Celda posicion) {
		posicion.ocupado = false;
		posicion.unidad = null;

	}

	public void moverUnidadTablero(Unidad unidad, Celda posActual, Celda destino) {
		posActual.quitarUnidadCelda(posActual);
		colocarUnidadTablero(unidad, destino);
	}

	// ---------------------------GETTERS-----------------------------------//
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Unidad getUnidadCelda() {
		return unidad;
	}
}
