package Mapa;

/**
 * Clase que genera el tablero/mapa y contiene las funciones de movimientos dentro del mismo
 * @author Lucas
 */
import Unidades.Arquero;
import Unidades.Caballero;
import Unidades.Unidad;
import grafics.Windows;

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

	public void prueba() {
		Arquero a1 = new Arquero(0, null);
		Caballero c1 = new Caballero(1, null);
		a1.setPosicion(tablero[2][1]);
		c1.setPosicion(tablero[2][2]);
		try {
			insertarUnidadTablero(c1, tablero[4][1]);
			insertarUnidadTablero(a1, tablero[5][1]);
			moverUnidadTablero(a1, a1.getPosicion(), tablero[4][1]);
			moverUnidadTablero(a1, a1.getPosicion(), tablero[4][1]);
		} catch (CeldaOcupadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// moverUnidadTablero(a1, a1.getPosicion(), tablero[8][0]);
		// moverUnidadTablero(a1, a1.getPosicion(), tablero[0][0]);
		// moverUnidadTablero(a1, a1.getPosicion(), tablero[1][0]);
		// moverUnidadTablero(c1, c1.getPosicion(), tablero[3][1]);
		// a1.atacar(a1, c1);
		// a1.atacar(a1, c1);
		// a1.atacar(a1, c1);
	}

	/**
	 * Funcion que genera el tablero
	 */

	public void generarTablero() {
		int i = 0;
		for (int x = 0; x < FILAS; x++) {
			for (int y = 0; y < COLUMNAS; y++) {
				tablero[x][y] = new Celda(x, y, (byte) i);
				i++;
				if (i == 4) {
					i = 0;
				}
			}
		}
	}

	/**
	 * Funcion para depositar una unidad dentro del mapa
	 * 
	 * @param unidad Unidad a insertar
	 * @param celda  En que celda se quiere insertar la unidad
	 * @throws CeldaOcupadaException
	 */

	public void insertarUnidadTablero(Unidad unidad, Celda celda) throws CeldaOcupadaException {
		if (!celda.getOcupado()) {
			celda.setUnidad(unidad); // INSERTO LA UNIDAD EN LA CELDA
			celda.setOcupado(true); // LA CELDA PASA A ESTAR OCUPADA
			unidad.setPosicion(celda); // LE ASIGNO LA NUEVA POSICION A LA UNIDAD
		} else {
			throw new CeldaOcupadaException();
		}
	}

	/**
	 * Funcion
	 * 
	 * @param unidad    Unidad a mover
	 * @param posActual La posicion en la que se encuentra la unidad
	 * @param destino   Celda a la que quiere dirigirse la unidad
	 */

	public void moverUnidadTablero(Unidad unidad, Celda posActual, Celda destino) {
		if (destino.getOcupado() == true) // SI QUIERE MOVERSE A UNA CELDA QUE ESTA OCUPADA POR UNA PIEZA ENEMIGA
		{
			if (destino.getUnidadCelda().getPropiedad() != posActual.getUnidadCelda().getPropiedad()) {
				if (!unidad.atacar(unidad, destino.getUnidadCelda())) {
					try {
						insertarUnidadTablero(unidad, posActual); // ATACO PERO NO MATO, QUE SE QUEDE EN SU LUGAR
					} catch (CeldaOcupadaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					try {
						insertarUnidadTablero(unidad, destino);
					} catch (CeldaOcupadaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		try {
			if (!validarMovimiento(unidad, posActual, destino) == true) // VERIFICO SI EL MOVIMIENTO ES VALIDO
			{
				try {
					insertarUnidadTablero(unidad, destino);
				} catch (CeldaOcupadaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // LA INSERTO EN EL DESTINO
			}

		} catch (MovimientoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Funcion que determina si la unidad esta queriendo realizar un movimiento
	 * valido o no
	 * 
	 * @param unidad    Unidad que quiere moverse
	 * @param posActual Posicion en la que se encuentra
	 * @param destino   Posicion a la que quiere moverse
	 * @return Un booleano que en caso de ser falso, es un movimiento invalido
	 * @throws MovimientoInvalidoException
	 */
	public static boolean validarMovimiento(Unidad unidad, Celda posActual, Celda destino)
			throws MovimientoInvalidoException // EN
	// CASO
	// DE
	// RETORNAR
	// TRUE,
	// EL
	// MOVIMIENTO ES VALIDO
	{
		boolean bandera = false;

		// PUEDE MOVERSE AL DESTINO SOLO SI ESTA A UNA CELDA DE DISTANCIA, SALVO QUE SEA
		// CABALLERO
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

		// SOLO PUEDE MOVERSE DENTRO DE LOS LIMITES DEL MAPA
		if (destino.getPosX() >= 0 && destino.getPosX() <= 7) {
			if (destino.getPosY() >= 0 && destino.getPosY() <= 3) {
				bandera = true;
			}
		}

		// PUEDE MOVERSE A UNA CELDA QUE ESTA VACIA
		if (destino.getOcupado() == false) {
			bandera = true;
		}

		// PUEDE MOVERSE UNA CELDA ENEMIGA PERO DEBE ATACARLA
		if (destino.getOcupado() == true) {
			if (destino.getUnidadCelda().getPropiedad() != unidad.getPropiedad()) {
				bandera = true;
			}
		}

		if (bandera == false) {
			throw new MovimientoInvalidoException("Movimiento inválido.");
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
		int[] spriteAux = new int[spriteSizePix * spriteSizePix];

		for (int i = 0; i < this.FILAS; i++) {
			for (int j = 0; j < this.COLUMNAS; j++) {
				spriteAux = pantalla.sprites.getPixeles(tablero[i][j].getTipoDeSprite());
				for (int x = spriteSizePix * i; x < spriteSizePix * i + 32; x++) {
					for (int y = spriteSizePix * j; y < spriteSizePix * j + 32; y++) {
						pantalla.pixeles[(x) + pantalla.getDifIz()
								+ ((y) + pantalla.getDifTop()) * pantalla.getWidth()] = spriteAux[(x % 32)
										+ (y % 32) * spriteSizePix];
					}
				}
				if (this.tablero[i][j].getOcupado()) {
					this.tablero[i][j].getUnidadCelda().mostrar(pantalla);
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
