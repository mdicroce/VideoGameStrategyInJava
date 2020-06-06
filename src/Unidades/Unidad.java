package Unidades;

import Mapa.Celda;

public abstract class Unidad {

	private String nombre;
	private double puntosVida;
	private double puntosAtaque;
	private double puntosDefensa;
	private int propiedad;
	private int id;
	private double costoOro;
	private Celda posicion;

	public Unidad() {
		nombre = "";
		puntosAtaque = -1;
		puntosVida = -1;
		puntosDefensa = -1;
		propiedad = 0;
		id = -1;
		costoOro = -1;
		posicion = null;
	}

	public Unidad(String nombre, double pVida, double pAtaque, double pDefensa, double costoOro, int propiedad,
			int id) {
		this.nombre = nombre;
		puntosVida = pVida;
		puntosAtaque = pAtaque;
		puntosDefensa = pDefensa;
		this.propiedad = propiedad;
		this.costoOro = costoOro;
		this.id = id;
		posicion = null;
	}

	// -------------------------------------METODOSPROPIOS-------------------------------------//

	public double atacar(Unidad atacante, Unidad defensora) {
		// Atacante realiza el ataque, pero la atacada tiene puntos de defensa, por lo
		// que primero calculo cuanto daño ocasiona
		double hurtOcasionado = defender(atacante, defensora);

		// Una vez calculado el daño, le resto a la vida de la unidad atacada
		defensora.puntosVida -= hurtOcasionado;

		if (defensora.puntosVida <= 0) {
			morir(defensora, defensora.posicion);
		}
		return hurtOcasionado;
	}

	public double defender(Unidad atacante, Unidad defensora) {
		double hurtOcasionado = atacante.puntosAtaque - defensora.puntosDefensa;
		return hurtOcasionado;
	}

	public void mover(Unidad unidad, Celda destino) {
		unidad.posicion = posicion;
	}

	public void morir(Unidad unidad, Celda posicionActual) {
		unidad.posicion.quitarUnidadCelda(posicionActual);
	}

	// -------------------------------------GETTERS--------------------------------------------//
	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public Celda getPosicion() {
		return posicion;
	}

	public int getPropiedad() {
		return propiedad;
	}

	public double getPuntosAtaque() {
		return puntosAtaque;
	}

	public double getPuntosDefensa() {
		return puntosDefensa;
	}

	public double getPuntosVida() {
		return puntosVida;
	}

	@Override
	public String toString() {
		return nombre + "PV: " + puntosVida;
	}

}
