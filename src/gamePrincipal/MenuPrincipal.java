package gamePrincipal;

import GuardadoYCarga.ExceptionNoHayArchivosGuardados;

/**
 * En esta clase esta el metodo menu y sus opciones. 
 * @author Nahue
 *
 */

public class MenuPrincipal {
	
	/**
	 * El menu principal para iniciar el juego (este menu es temporal).
	 */
	public void menu() {
		
		PantallaOpciones.mostrarOpciones();
		int op = -1;
		
		while (op != 0 & op != 1 & op != 2 ) {	
			
			
			op = PantallaOpciones.leerOpcionTeclado();
			       
		    switch (op){
			           
		       	case 1:    
		       		
		       		OPnuevoJuego();
			        
		       		break;
			    case 2: 
			    	
					OPcargarJuego();
			   
					break;
				case 0:
					System.out.println("\n\t\tHasta la proxima batalla");
					System.exit(0);
					break;
		           
			    default:    
			    	System.out.println("OPCION INVALIDA. Vuelva a ingresar una opcion valida");
		    }
		
		}     
	}
	
	/**
	 * Opcion para crear una nueva partida.
	 */
	public void OPnuevoJuego() {
		
		Partida partidaNueva = PantallaOpciones.crearPartidaNueva();
		GameMain  jueguitos = new GameMain(partidaNueva);
		jueguitos.iniciar();
		
		
	}
	
	/**
	 * Opcion para cargar una partida y si eto no es posible crea un nuevo juego.
	 */
	
	public void OPcargarJuego() {
		
		try {
			PantallaOpciones.mostrarArchivosGuardados();
			int posArch = PantallaOpciones.leerOpcionTeclado();
			Partida partidaCargada = PantallaOpciones.cargarPartidaGuardada(PantallaOpciones.buscarNombreArchi(posArch));
			GameMain  jueguitos = new GameMain(partidaCargada);
			jueguitos.iniciar();
		} catch (ExceptionNoHayArchivosGuardados e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
			OPnuevoJuego();
		}
		
	} 
	
}
