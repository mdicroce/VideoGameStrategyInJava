package Jugadores;

import Unidades.Unidad;

public class Jugador {
	
	private String name;

	private int idPlayer;

	private int limiteY;

	private Cuartel<Unidad> cuartel;

	public Jugador (String name,int idPlayer,int limiteY) {
		this.name = name;
		
		this.idPlayer = idPlayer;
		
		this.limiteY = limiteY;
		
		cuartel = new Cuartel<Unidad>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public int getLimiteY() {
		return limiteY;
	}

	public void setLimiteY(int limiteY) {
		this.limiteY = limiteY;
	}


	
	//public void seleccionar();

	//public void cederTurno();

	//public void selecionarUnida ();

}

