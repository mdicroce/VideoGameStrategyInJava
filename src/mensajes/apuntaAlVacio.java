package mensajes;

import Jugadores.Jugador;
import gamePrincipal.GameController;
import grafics.CuadroTextoG;

public class apuntaAlVacio {
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
	private void cargaDeMensajes() {
		texto.cargarMensajes("Cuartel");
		texto.cargarMensajes("Pasar Turno");
		texto.cargarMensajes("Rendirse");
		texto.cargarMensajes("Cancelar");
		texto.setSeleccionable(true);
	}
	private void seleccion() {
		int seleccionado;
		do {
			seleccionado = texto.actualizar(this.teclado);
		}while (seleccionado == -1);
		
	}
	
}
