package gamePrincipal;

import GuardadoYCarga.ExceptionNoHayArchivosGuardados;

public class MenuPrincipal {
	
	
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
	
	
	public void OPnuevoJuego() {
		
		Partida partidaNueva = PantallaOpciones.crearPartidaNueva();
	
	}
	
	public void OPcargarJuego() {
		
		try {
			PantallaOpciones.mostrarArchivosGuardados();
			int posArch = PantallaOpciones.leerOpcionTeclado();
			Partida partidaCargada = PantallaOpciones.cargarPartidaGuardada(PantallaOpciones.buscarNombreArchi(posArch));
	
		} catch (ExceptionNoHayArchivosGuardados e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
			OPnuevoJuego();
		}
		
	} 
	
}
