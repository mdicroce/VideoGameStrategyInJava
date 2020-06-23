package Mapa;

import java.util.HashMap;

import Unidades.Caballero;
import gamePrincipal.GamePruebasPantalla;
import grafics.Sprite;
import grafics.SpriteSheet;
import grafics.Windows;
import maps.cuadros.Tiles;

import Unidades.Unidad;

public class MapaTablero {
	private final int FILAS;
	private final int COLUMNAS;
	private Celda tablero[][];
	private int anchoPix;
	private int altoPix;
	private int sizeTile;

	public MapaTablero(int FILAS, int COLUMNAS, int sizeTile) {
		this.FILAS = FILAS;
		this.COLUMNAS = COLUMNAS;
		this.anchoPix = sizeTile * COLUMNAS;
		this.altoPix = sizeTile * FILAS;
		this.sizeTile = sizeTile;	
		tablero = new Celda[FILAS][COLUMNAS];
		generarTablero();
	}

	// -----------------------------------------------------//


	public void generarTablero() {
		int i = 0;
		for (int x = 0; x < FILAS; x++) {
			for (int y = 0; y < COLUMNAS; y++) {
				tablero[x][y] = new Celda(x, y,(byte) i);
				i++;
				if (i==4) {
					i = 0;
				}
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
	public void mostrar(Windows pantalla, int spriteSizePix) {
		int[] pixelesAux = new int [spriteSizePix];
		for (int i = 0; i<(altoPix/sizeTile);i++) {
			for (int j = 0; j<(anchoPix/sizeTile);j++) {
				pixelesAux = pantalla.sprites.getPixeles(tablero[i][j].getTipoDeSprite());
				for (int y = sizeTile*i; y < altoPix; y++) {
					for (int x = sizeTile * j; x < anchoPix; x ++) {
						pantalla.pixeles[(x+pantalla.getDifIz()) + (y+pantalla.getDifTop()) * anchoPix] = pixelesAux[(x%32) + (y%32) * pantalla.sprites.getSize()];
						if ( tablero[i][j].getOcupado()) 
						{
							tablero[i][j].getUnidadCelda().mostrar(pantalla);
						}
					}
				}
			}
		}
		
	}
	public void actualizar() {
		
	}
	// ------------------------Getters-----------------------------//
	public int getFilas() {
		return FILAS;
	}

	public int getColumnas() {
		return COLUMNAS;
	}

	public Celda[][] getTablero() {
		return tablero;
	}

	public int getAnchoPix() {
		return anchoPix;
	}

	public int getAltoPix() {
		return altoPix;
	}

	public int getSizeTile() {
		return sizeTile;
	}
}

