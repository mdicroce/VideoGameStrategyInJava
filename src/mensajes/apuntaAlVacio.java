package mensajes;

import Jugadores.Jugador;
import gamePrincipal.GameController;
import grafics.CuadroTextoG;
import grafics.Windows;

public class apuntaAlVacio extends Textos {
	private Jugador playerActual;
	private GameController teclado;
	private Windows ventana;
	public apuntaAlVacio(Jugador player, GameController teclado)
	{
		playerActual = player;
		this.teclado = teclado;
		this.ventana = ventana;
		
		
	}
	public void cargaDeMensajes(CuadroTextoG textoG){
		textoG.cargarMensajes("cuartel");
		textoG.cargarMensajes("pasar turno");
		textoG.cargarMensajes("rendirse");
		textoG.cargarMensajes("cancelar");
		textoG.cargarMensajes("guardar");
		textoG.setSeleccionable(true);
		textoG.tipoDeOpcion = 0;
	}
	private void seleccion() {
		
	}

	
}
