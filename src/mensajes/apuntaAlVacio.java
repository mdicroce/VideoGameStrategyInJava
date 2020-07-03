package mensajes;

import Jugadores.Jugador;
import gamePrincipal.GameController;
import grafics.CuadroTextoG;
import grafics.Windows;

public class apuntaAlVacio extends Textos {
	private CuadroTextoG texto;
	private Jugador playerActual;
	private GameController teclado;
	private Windows ventana;
	public apuntaAlVacio(Jugador player, GameController teclado)
	{
		texto = new CuadroTextoG();
		playerActual = player;
		cargaDeMensajes();
		this.teclado = teclado;
		this.ventana = ventana;
		
		
	}
	public void cargaDeMensajes(){
		texto.cargarMensajes("Cuartel");
		texto.cargarMensajes("Pasar Turno");
		texto.cargarMensajes("Rendirse");
		texto.cargarMensajes("Cancelar");
		texto.setSeleccionable(true);
	}
	private void seleccion() {
		texto.mostrar(ventana);
		if (texto.actualizar(teclado))
		{
			switch (texto.getSelected()) {
			case 0:
				
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;

			default:
				break;
			}
		}
	}
	
}
