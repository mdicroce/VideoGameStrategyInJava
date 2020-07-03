package mensajes;

import java.util.ArrayList;

import Jugadores.ExceptionEstaVacio;
import Jugadores.Jugador;
import grafics.CuadroTextoG;

public class textoListaCuartel extends Textos {

	ArrayList<String> textosCuartel;
	public textoListaCuartel(Jugador player) {
		try {
			textosCuartel = player.getCuartel().listar();
		} catch (ExceptionEstaVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	@Override
	public void cargaDeMensajes(CuadroTextoG textoG) {
		for (int i = 0; i < textosCuartel.size();i++) {
			textoG.cargarMensajes(textosCuartel.get(i));
		}
		textoG.setSeleccionable(true);
		textoG.tipoDeOpcion = 4;
		
	}
	
}
