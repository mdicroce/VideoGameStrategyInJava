package Unidades;

import org.json.JSONException;
import org.json.JSONObject;

import Mapa.Celda;
import grafics.Windows;

/**
 * Esta clase abstracta representa los atributos que toda Unidad tendr� por
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
			double costoOroGuarecido, double costoOroCampo, int propiedad, Celda posicion) {
		this.nombre = nombre;
		puntosVida = pVida;
		puntosAtaque = pAtaque;
		puntosDefensa = pDefensa;
		this.propiedad = propiedad;
		this.costoOroCompra = costoOro;
		this.costoOroGuarecido = costoOroGuarecido;
		this.costoOroEnCampo = costoOroCampo;
		this.idUnidad = idIncremento++;
		this.posicion = posicion;
	}

	// -------------------------------------METODOSPROPIOS-------------------------------------//

	public void mostrar(Windows pantalla) {
		int x2 = -1;
		int y2 = -1;
		int tope = pantalla.getDifTop() + this.posicion.getPosY() * 32,
				topeIz = pantalla.getDifIz() + this.posicion.getPosX() * 32;
		for (int y = tope - 32; y < tope; y++) {
			y2++;
			for (int x = topeIz; x < topeIz + 32; x++) {

				x2++;

				if (pantalla.sprites.pixeles[pos1][(x2 % 32) + (y2 % 32) * pantalla.sprites.getSize()] != -16711936)
					pantalla.pixeles[x + y * pantalla.getWidth()] = pantalla.sprites.pixeles[pos1][(x2 % 32)
							+ (y2 % 32) * pantalla.sprites.getSize()];
			}
		}
		x2 = -1;
		y2 = -1;
		for (int y = tope; y < tope + 32; y++) {
			y2++;
			for (int x = topeIz; x < topeIz + 32; x++) {
				x2++;
				if (pantalla.sprites.pixeles[pos2][(x2 % 32) + (y2 % 32) * pantalla.sprites.getSize()] != -16711936)
					pantalla.pixeles[x + y * pantalla.getWidth()] = pantalla.sprites.pixeles[pos2][(x2 % 32)
							+ (y2 % 32) * pantalla.sprites.getSize()];
			}
		}
	}

	public boolean atacar(Unidad atacante, Unidad defensora) {
		boolean murio = false;
		boolean valido = validarAtaque(atacante, defensora); // Valido si la unidad puede atacar.
		double hurtOcasionado = 0;
		if (valido == true) {
			// Atacante realiza el ataque, pero la unidad que es atacada tiene puntos de
			// defensa, por lo
			// que primero calculo cuanto da�o ocasiona
			hurtOcasionado = defender(atacante, defensora);

			// Una vez calculado el da�o, le resto a la vida de la unidad atacada
			defensora.puntosVida -= hurtOcasionado;

			if (defensora.puntosVida <= 0) {
				morir(defensora, defensora.posicion);
				murio = true;
			}
		}

		return murio;
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

	public JSONObject toJsonObject() throws JSONException {
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
		jsonObject.put("Celda posicion", posicion.toJsonObject());
		jsonObject.put("Posicion 1", pos1);
		jsonObject.put("Posicion 2", pos2);

		return jsonObject;
	}

	public void decodeJsonObject(JSONObject jsonObject) throws JSONException {

		setNombre(jsonObject.getString("Nombre"));
		setPuntosVida(jsonObject.getDouble("Puntos de Vida"));
		setPuntosAtaque(jsonObject.getDouble("Puntos de Ataque"));
		setPuntosDefensa(jsonObject.getDouble("Puntos de Defensa"));
		setPropiedad(jsonObject.getInt("Propiedad"));
		setIdUnidad(jsonObject.getInt("ID"));
		setCostoOroCompra(jsonObject.getDouble("Costo de oro Compra"));
		setCostoOroGuarecido(jsonObject.getDouble("Costo de oro Guarecido"));
		setCostoOroEnCampo(jsonObject.getDouble("Costo de oro en Campo"));

		jsonObject.getJSONObject("Celda posicion");

		setPos1(jsonObject.getInt("Posicion 1"));
		setPos2(jsonObject.getInt("Posicion 2"));

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

	public static int getIdIncremento() {
		return idIncremento;
	}

	public int getPos1() {
		return pos1;
	}

	public int getPos2() {
		return pos2;
	}

	// -------------------------------------SETTERS--------------------------------------------//

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPuntosVida(double puntosVida) {
		this.puntosVida = puntosVida;
	}

	public void setPuntosAtaque(double puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}

	public void setPuntosDefensa(double puntosDefensa) {
		this.puntosDefensa = puntosDefensa;
	}

	public void setPropiedad(int propiedad) {
		this.propiedad = propiedad;
	}

	public static void setIdIncremento(int idIncremento) {
		Unidad.idIncremento = idIncremento;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

	public void setCostoOroCompra(double costoOroCompra) {
		this.costoOroCompra = costoOroCompra;
	}

	public void setCostoOroGuarecido(double costoOroGuarecido) {
		this.costoOroGuarecido = costoOroGuarecido;
	}

	public void setCostoOroEnCampo(double costoOroEnCampo) {
		this.costoOroEnCampo = costoOroEnCampo;
	}

	public void setPos1(int pos1) {
		this.pos1 = pos1;
	}

	public void setPos2(int pos2) {
		this.pos2 = pos2;
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
