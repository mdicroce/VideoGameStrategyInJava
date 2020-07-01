package Unidades;

import org.json.JSONException;
import org.json.JSONObject;

import Mapa.Celda;
import grafics.Windows;

/**
 * Esta clase abstracta representa los atributos que toda Unidad tendrá por
 * defecto
 * 
 * @author Lucas
 *
 */

public abstract class Unidad {

	private String nombre;
	private double puntosVida;
	private double puntosAtaque;
	private double puntosDefensa;
	private int propiedad; // a que jugador pertenece
	private static int idIncremento;
	private int idUnidad;
	private double costoOroCompra;
	private double costoOroGuarecido;
	private double costoOroEnCampo; // PUESTO EN EL TABLERO
	private Celda posicion;
	protected int pos1, pos2;

	public Unidad() {
		nombre = "";
		puntosAtaque = -1;
		puntosVida = -1;
		puntosDefensa = -1;
		propiedad = 0;
		idUnidad = idIncremento++;
		costoOroCompra = -1;
		costoOroGuarecido = 0;
		costoOroEnCampo = 0;
		posicion = null;
	}

	public Unidad(String nombre, double pVida, double pAtaque, double pDefensa, double costoOro,
			double costoOroGuarecido, double costoOroCampo, int propiedad) {
		this.nombre = nombre;
		puntosVida = pVida;
		puntosAtaque = pAtaque;
		puntosDefensa = pDefensa;
		this.propiedad = propiedad;
		this.costoOroCompra = costoOro;
		this.costoOroGuarecido = costoOroGuarecido;
		this.costoOroEnCampo = costoOroCampo;
		this.idUnidad = idIncremento++;
		posicion = null;
	}

	public void mostrar(Windows pantalla) {
		for (int y = 0; y < 64; y++) {
			for (int x = 0; x < 32; x++) {
				pantalla.pixeles[(x + posicion.getPosX() * 32)
						+ (y + posicion.getPosY() * 32) * pantalla.sprites.getSize()] = pantalla.sprites.pixeles[pos2][x
								+ y * pantalla.sprites.getSize()];
				pantalla.pixeles[(x + posicion.getPosX() * 32) + ((y - 32) + posicion.getPosY() * 32)
						* pantalla.sprites.getSize()] = pantalla.sprites.pixeles[pos1][x
								+ y * pantalla.sprites.getSize()];
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

	public JSONObject toJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("Nombre", nombre);
		jsonObject.put("Puntos de Vida", puntosVida);
		jsonObject.put("Puntos de Ataque", puntosAtaque);
		jsonObject.put("Puntos de Defensa", puntosDefensa);
		jsonObject.put("Propiedad", propiedad);
		jsonObject.put("ID", idUnidad);
		jsonObject.put("Costo de oro Compra", costoOroCompra);
		jsonObject.put("Costo de oro Guarecido", costoOroGuarecido);
		jsonObject.put("Costo de oro en Campo", costoOroEnCampo);
		jsonObject.put("Celda posicion", posicion.toJson());
		jsonObject.put("Costo de oro Compra", costoOroCompra);
		jsonObject.put("Posicion 1", pos1);
		jsonObject.put("Posicion 2", pos2);

		return jsonObject;
	}

	// -------------------------------------GETTERS--------------------------------------------//
	public String getNombre() {
		return nombre;
	}

	public int getIdUnidad() {
		return idUnidad;
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
		return nombre + idUnidad + "PV: " + puntosVida;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bandera = false;
		if (obj instanceof Unidad) {
			Unidad aux = (Unidad) obj;
			if (aux.getIdUnidad() == this.getIdUnidad()) {
				bandera = true;
			}
		}
		return bandera;
	}

}
