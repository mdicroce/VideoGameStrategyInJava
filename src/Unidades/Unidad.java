package Unidades;

import Mapa.Celda;
import grafics.Windows;

public abstract class Unidad {

	private String nombre;
	private double puntosVida;
	private double puntosAtaque;
	private double puntosDefensa;
	private int propiedad; // a que jugador pertenece
	private static int id;
	private double costoOroCompra;
	private double costoOroGuarecido;
	private double costoOroEnCampo; // PUESTO EN EL TABLERO
	private Celda posicion;
	protected int pos1,pos2;

	public Unidad() {
		nombre = "";
		puntosAtaque = -1;
		puntosVida = -1;
		puntosDefensa = -1;
		propiedad = 0;
		id++;
		costoOroCompra = -1;
		costoOroGuarecido = 0;
		costoOroEnCampo = 0;
		posicion = null;
	}

	public Unidad(String nombre, double pVida, double pAtaque, double pDefensa, double costoOro,
			double costoOroGuarecido, double costoOroCampo, int propiedad, int id) {
		this.nombre = nombre;
		puntosVida = pVida;
		puntosAtaque = pAtaque;
		puntosDefensa = pDefensa;
		this.propiedad = propiedad;
		this.costoOroCompra = costoOro;
		this.costoOroGuarecido = costoOroGuarecido;
		this.costoOroEnCampo = costoOroCampo;
		Unidad.id = id++;
		posicion = null;
	}
	public void mostrar(Windows pantalla) {
		for (int y = 0; y < 64 ;y++) {
			for (int x = 0; x < 32;x++) {
				pantalla.pixeles[(x+posicion.getPosX()*32)+(y+posicion.getPosY()*32)*pantalla.sprites.getSize()]= pantalla.sprites.pixeles[pos2][x+y*pantalla.sprites.getSize()];
				pantalla.pixeles[(x+posicion.getPosX()*32)+((y-32)+posicion.getPosY()*32)*pantalla.sprites.getSize()] = pantalla.sprites.pixeles[pos1][x+y*pantalla.sprites.getSize()];
			}
		}
	}

	// -------------------------------------METODOSPROPIOS-------------------------------------//

	public double atacar(Unidad atacante, Unidad defensora) {
		boolean valido = validarAtaque(atacante, defensora); // Valido si la unidad puede atacar.
		double hurtOcasionado = 0;
		if (valido == true) {
			// Atacante realiza el ataque, pero la unidad que es atacada tiene puntos de
			// defensa, por lo
			// que primero calculo cuanto daño ocasiona
			hurtOcasionado = defender(atacante, defensora);

			// Una vez calculado el daño, le resto a la vida de la unidad atacada
			defensora.puntosVida -= hurtOcasionado;

			if (defensora.puntosVida <= 0) {
				morir(defensora, defensora.posicion);
			}
		}

		return hurtOcasionado;
	}

	public boolean validarAtaque(Unidad atacante, Unidad defensora) {
		boolean bandera = false;
		if (atacante instanceof Arquero) { // ARQUERO PUEDE ATACAR A DOS CELDAS DE DISTANCIA
			if (Math.abs(atacante.getPosicion().getPosX() - defensora.getPosicion().getPosX()) <= 2) {
				if (Math.abs(atacante.getPosicion().getPosY() - defensora.getPosicion().getPosY()) <= 2) {
					bandera = true;
				}
			}
		} else if (Math.abs(atacante.getPosicion().getPosX() - defensora.getPosicion().getPosX()) == 1) {
		}
		if (Math.abs(atacante.getPosicion().getPosY() - defensora.getPosicion().getPosY()) == 1) {
			bandera = true;
		}
		return bandera;
	}

	public double defender(Unidad atacante, Unidad defensora) {
		double hurtOcasionado = 0;
		if (defensora instanceof Infanteria) // BONUS INFANTERIA
		{
			if (((Infanteria) defensora).getBonusDisponible() == true) {
				double defensaBonusInfanteria = defensora.getPuntosDefensa() * 2;
				hurtOcasionado = atacante.puntosAtaque - defensaBonusInfanteria;
			}
		}
		hurtOcasionado = atacante.puntosAtaque - defensora.puntosDefensa;
		return hurtOcasionado;
	}

	public void setPosicion(Celda posicion) {
		this.posicion = posicion;
	}

	public void moverArriba(Unidad unidad, Celda destino) {
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

	public double getCostoOroCompra() {
		return costoOroCompra;
	}

	public double getCostoOroEnCampo() {
		return costoOroEnCampo;
	}

	public double getCostoOroGuarecido() {
		return costoOroGuarecido;
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

	// -------------------------------------------OVERRIDES----------------------------------------//

	@Override
	public String toString() {
		return nombre + id + "PV: " + puntosVida;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bandera = false;
		if (obj instanceof Unidad) {
			Unidad aux = (Unidad) obj;
			if (aux.getId() == this.getId()) {
				bandera = true;
			}
		}
		return bandera;
	}

}
