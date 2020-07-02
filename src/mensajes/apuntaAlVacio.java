package mensajes;

import Jugadores.Jugador;
import gamePrincipal.GameController;
import grafics.CuadroTextoG;

public class apuntaAlVacio extends Textos {
	private CuadroTextoG texto;
	private Jugador playerActual;
	private GameController teclado;
	public apuntaAlVacio(Jugador player, GameController teclado)
	{
		texto = new CuadroTextoG();
		playerActual = player;
		cargaDeMensajes();
		this.teclado = teclado;
		
		
	}
	public void cargaDeMensajes(){
		texto.cargarMensajes("Cuartel");
		texto.cargarMensajes("Pasar Turno");
		texto.cargarMensajes("Rendirse");
		texto.cargarMensajes("Cancelar");
		texto.setSeleccionable(true);
	}
	private void seleccion() {
		
		
		
	}
	
}
