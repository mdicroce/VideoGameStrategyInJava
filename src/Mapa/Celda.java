package Mapa;

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

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public void quitarUnidadCelda(Celda celda) {
		celda.unidad = null;
		celda.ocupado = false;
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

	public boolean getOcupado() {
		return ocupado;
	}

	@Override
	public String toString() {
		return "[ " + posX + "] [" + posY + "]" + unidad;
	}
}
