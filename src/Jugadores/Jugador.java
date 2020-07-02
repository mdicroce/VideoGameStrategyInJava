package Jugadores;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Mapa.Celda;
import Mapa.MapaTablero;
import Unidades.Arquero;
import Unidades.Caballero;
import Unidades.Infanteria;

/**
 * Clase Jugadores la cual posee una contenedor generico  llamado cuartel el cual posee unidades 
 * 
 * 
 * @author Nahuel Flores
 *
 */

import Unidades.Unidad;

/**
 * Clase Jugador que coniene un Contenedor Generico llamado cuartel que contiene Unidades.
 * En esta clase se puede sumar oro al jugador, restar oro al jugador, agregar una unidad al Cuartel, eliminar una unidad del Cuartel, buscar una unidad del Cuartel, terminar turno, convertir la clase a un JSONObject, settear la clase a partir de un JSONObject.
 * @author Nahue
 *
 */

public class Jugador {
	
	private String name;

	private int idPlayer;
	
	private double oro;

	private int limiteYMayor;
	
	private int limiteYMenor;
	
	private boolean turno;
	
	private int cantAcciones;
	
	private Cuartel<Unidad> cuartel;
	
	
	
	public Jugador () {
		name = "";
		
		idPlayer = 0;
		
		oro = 0;
		
		limiteYMayor = -1;
		
		limiteYMenor = -1;
		
		turno = false;
		
		cantAcciones = 0;
		
		cuartel = new Cuartel<Unidad>();
	}

	public Jugador (String name,int idPlayer,double oro,int limiteYMayor,int limiteYMenor) {
		this.name = name;
		
		this.idPlayer = idPlayer;
		
		this.oro = oro;
		
		this.limiteYMayor = limiteYMayor;
		
		this.limiteYMenor = limiteYMenor;
		
		turno = false;
		
		this.cantAcciones = 3;
		
		cuartel = new Cuartel<Unidad>();
	}

// -------------------------------------GETTERS--------------------------------------------//
	
	public String getName() {
		return name;
	}

	public int getIdPlayer() {
		return idPlayer;
	}
	
	public double getOro() {
		return oro;
	}
	
	public int getLimiteYMayor() {
		return limiteYMayor;
	}
	
	public int getLimiteYMenor() {
		return limiteYMenor;
	}
	
	public boolean getTurno() {
		return turno;
	}
	
	public int getCantAcciones() {
		return cantAcciones;
	}
	
	public Cuartel<Unidad> getCuartel() {
		return cuartel;
	}
	
// -------------------------------------SETTERS--------------------------------------------//		
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}
	
	public void setOro(double oro) {
		this.oro = oro;
	}

	public void setLimiteYMayor(int limiteYMayor) {
		this.limiteYMayor = limiteYMayor;
	}

	public void setLimiteYMenor(int limiteYMenor) {
		this.limiteYMenor = limiteYMenor;
	}
	
	public void setTurno(boolean turno) {
		this.turno = turno;
	}
	
	public void setCantAcciones(int cantAcciones) {
		this.cantAcciones = cantAcciones;
	}

	public void setCuartel(Cuartel<Unidad> cuartel) {
		this.cuartel = cuartel;
	}
	
// -------------------------------------METODOS PROPIOS-------------------------------------//

	/**
	 * Le resta el oro pasado por parametro a el jugador. 
	 * @param cant Un double con la cantidad de oro a restar.
	 */
	public void restarOro(double cant) {
		oro = oro - cant;
	}

	/**
	 * Le suma el oro pasado por parametro a el jugador.
	 * @param cant Un double con la cantidad de oro a sumar.
	 */
	public void sumarOro(double cant) {
		oro = oro + cant;
	}
	
	
	
	/**
	 * Agrega la unidad pasada por parametro al Cuartel.
	 * @param unidad a agregar al cuartel.
	 */
	public void agregarUnidadAlCuartel(Unidad unidad) {
		
		try {
			cuartel.agregar(unidad);
		} catch (ExceptionNoSePudoAgregar e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Busca y elimina la unidad pasada por parametro.
	 * @param eliminar Objeto a eliminar del tipo unidad.
	 */
	public void eliminarUnidadAlCuartel(Unidad eliminar) {
		
			try {
				cuartel.eliminar(eliminar);
			} catch (ExceptionNoExiste e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionEstaVacio e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * Busca la unidad pasada por parametro mediante la comparacion con las unidades que se encuentran dentro del Cuartel.
	 * @param buscar Objeto a buscar del tipo unidad.
	 * @return retorna la unidad buscada.
	 */
	public Unidad buscarUnidadAlCuartel(Unidad buscar) {
		Unidad unidad = null;
		
		try {
			unidad = cuartel.buscar(buscar);
		} catch (ExceptionNoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionEstaVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return unidad;
	}
	
	/**
	 * Busca la unidad mediante la comparacion de las Celdas de las unidades con la Celda pasada por parametro.
	 * @param posicion Una Celda donde se ubica la posicion del Objeto a buscar del tipo unidad.
	 * @return retorna la unidad buscada.
	 */
	public Unidad buscarUnidadAlCuartel(Celda posicion) {
		Unidad unidad = null;
		try {
			unidad = cuartel.buscar(posicion);
		} catch (ExceptionNoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionEstaVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return unidad;
	}
	
	/**
	 * Busca la unidad mediante la posicion pasada por parametro.
	 * @param pos un int de la posicion a buscar en el Cuartel.
	 * @return retorna la unidad buscada.
	 */
	public Unidad buscarUnidadAlCuartel(int pos) {
		Unidad unidad = null;
		try {
			unidad = cuartel.buscar(pos);
		} catch (ExceptionNoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionEstaVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return unidad;
	}
	
	/**
	 * Termina el turno y vuelve la cantidad de acciones al valor Original
	 */
	public void terminarTurno() {
		turno = false;
		cantAcciones = 3;
	}

	/**
	 * Recorre el cuartel y revisa si las unidades se tienen que mostrar en el mapa.
	 * Si la unidad se tiene que mostrar en el mapa se setea la unidad en la celda. 
	 */
	public void linkearUnidadConSuPosOcupada() {
		Unidad unidad;
		Celda celda;
		int i = 0;

		while(cuartel.getValidos()>i) {
			
			unidad = buscarUnidadAlCuartel(i);
			celda = unidad.getPosicion();
			if(celda != null) {
				celda.setUnidad(unidad);
			}
			
			i++;
		}
	}
	
	
	/**
	 * Convierte el jugador a un JSONObject.
	 * @return Un JSONObject construido a partir de todos los elementos la clase jugador.
	 * @throws JSONException es lanzada cuando ocurre un error con los puts del JSONObject.
	 */
	public JSONObject toJsonObject() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Nombre", name);
		jsonObject.put("ID Jugador", idPlayer);
		jsonObject.put("Oro", oro);
		jsonObject.put("Limite Y Mayor", limiteYMayor);
		jsonObject.put("Limite Y Menor", limiteYMenor);
		jsonObject.put("Turno", turno);
		jsonObject.put("Cantidad de Acciones", cantAcciones);
		jsonObject.put("Cuartel", toJsonArray());
		
	return jsonObject;	
	}
	
	/**
	 * Convierte el Cuartel a un JSONArray.	
	 * @return JSONArray construido a partir del Cuartel y todos sus elementos.
	 * @throws JSONException es lanzada cuando ocurre un error con los puts del JSONArray.
	 */
	public JSONArray toJsonArray() {
		JSONArray jsonArray = new JSONArray();
		Unidad unidad;
		int i = 0;

		while(cuartel.getValidos()>i) {
			
			
			try {
				unidad = cuartel.buscar(i);
				
				if (unidad instanceof Infanteria) {// Esto se realiza ya que la infanteria tiene un toJson diferente
					Infanteria infanteria = (Infanteria) unidad;
					jsonArray.put(i, infanteria.toJsonObject());
				} else {
					jsonArray.put(i, unidad.toJsonObject());
						}
			} catch (ExceptionNoExiste e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionEstaVacio e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			i++;
		}

		return jsonArray;
	}
	
	
	/**
	 * Settea los atributos de la clase Persona a partir de un JSONObject y la utilizacion de los Setters.
	 * 
	 * @param jsonObject Un JSONObject por parametro que se va a utilizar para settear el Jugador.
	 * @throws JSONException es lanzada cuando ocurre un error con los gets del JSONObjects.
	 */
	public void decodeJsonObject(JSONObject jsonObject) throws JSONException {
		
		setName(jsonObject.getString("Nombre"));
		setIdPlayer(jsonObject.getInt("ID Jugador"));
		setOro(jsonObject.getDouble("Oro"));
		setLimiteYMayor(jsonObject.getInt("Limite Y Mayor"));
		setLimiteYMenor(jsonObject.getInt("Limite Y Menor"));
		setTurno(jsonObject.getBoolean("Turno"));
		setCantAcciones(jsonObject.getInt("Cantidad de Acciones"));
		
		decodeJsonArray(jsonObject.getJSONArray("Cuartel"));
	}
	
	/**
	 * Recorre el JSONArray y llama repetidamente a la funcion decodeUnidad que le pasa por parametro el JSONObject de la unidad que se quiera volver a cargar.
	 * 
	 * @param jsonArray Un JSONArray por parametro que se va a utilizar para cargar el cuartel.
	 */
	public void decodeJsonArray(JSONArray jsonArray) {
		
		int i = 0;
		
		while (i<jsonArray.length()) {
			try {
				decodeUnidad(jsonArray.getJSONObject(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionNoSePudoAgregar e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			i++;
		}
		
	}
	
	/**
	 * Crea la unidad a partir del JSONObject pasado por parametro y la agrega al Cuartel.
	 * @param unidadJsonObject JSONObject de la unidad a decodificar y luego agregar al cuartel.
	 * @throws JSONException es lanzada cuando ocurre un error con los gets del JSONObject.
	 * @throws ExceptionNoSePudoAgregar es lanzada cuando no se puede agregar la unidad al Cuartel.
	 */
	public void decodeUnidad(JSONObject unidadJsonObject) throws JSONException, ExceptionNoSePudoAgregar {
		
		String nombre = unidadJsonObject.getString("Nombre");
		
		if (nombre.compareToIgnoreCase("Arquero") == 1) {
			Arquero arquero = new Arquero();
			arquero.decodeJsonObject(unidadJsonObject);
			cuartel.agregar(arquero);
			
		} else {
			if (nombre.compareToIgnoreCase("Caballero") == 1) {
				Caballero caballero = new Caballero();
				caballero.decodeJsonObject(unidadJsonObject);
				cuartel.agregar(caballero);
				
			} else {
				Infanteria infanteria = new Infanteria();
				infanteria.decodeJsonObject(unidadJsonObject);
				cuartel.agregar(infanteria);
				
			}
		}
		
	}
	

	
	
	public void seleccionar(MapaTablero mapita)
	{
		
	}


	//public void selecionarUnida ();

}

