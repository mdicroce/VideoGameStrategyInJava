package Jugadores;

import Unidades.Unidad;

public class Jugador {
	
	private String name;

	private int idPlayer;
	
	private float oro;

	private int limiteYMayor;
	
	private int limiteYMenor;
	
	private Cuartel<Unidad> cuartel;

	public Jugador (String name,int idPlayer,float oro,int limiteYMayor,int limiteYMenor) {
		this.name = name;
		
		this.idPlayer = idPlayer;
		
		this.oro = oro;
		
		this.limiteYMayor = limiteYMayor;
		
		this.limiteYMenor = limiteYMenor;
		
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
	
	
	public float getOro() {
		return oro;
	}

	public void setOro(float oro) {
		this.oro = oro;
	}

	public int getLimiteYMayor() {
		return limiteYMayor;
	}

	public void setLimiteYMayor(int limiteYMayor) {
		this.limiteYMayor = limiteYMayor;
	}

	public int getLimiteYMenor() {
		return limiteYMenor;
	}

	public void setLimiteYMenor(int limiteYMenor) {
		this.limiteYMenor = limiteYMenor;
	}

	public Cuartel<Unidad> getCuartel() {
		return cuartel;
	}

	public void setCuartel(Cuartel<Unidad> cuartel) {
		this.cuartel = cuartel;
	}

	public void restarOro(float cant) {
		oro = oro - cant;
	}
	
	public void sumarOro(float cant) {
		oro = oro + cant;
	}
	
	
	//public void seleccionar();

	//public void cederTurno();

	//public void selecionarUnida ();

}

