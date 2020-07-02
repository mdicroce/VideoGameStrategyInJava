package gamePrincipal;

import java.util.ArrayList;
import java.util.Scanner;

import GuardadoYCarga.ExceptionNoHayArchivosGuardados;
import GuardadoYCarga.NombreArchivosGuardados;

public class PantallaOpciones {
	
	
	
	
	public void mostrarOpciones() {
		
		System.out.println("\tMenu Principal");
		System.out.println("\n\n 1 - Crear Partida Nueva");
		System.out.println("\n\n 2 - Cargar Partida Guardada");
		System.out.println("\n\n 0 - Salir");
			
	}
	
	public void crearPartidaNueva() {
		
		Partida partida = new Partida(50);
		
		partida.crearNuevaPartida();
	}
	
	public void cargarPartidaGuardada(String nombreArchi) {
		
		Partida partida = new Partida();
		
		partida.cargarPartida(nombreArchi);;
	}
	
	public int leerOpcionTeclado() {
		int op;
		Scanner scan = new Scanner(System.in);		
		System.out.println("\n\tIngrese una opcion");
		op = scan.nextInt();
				
		scan.close();
		
		return op;
	}
	
	public void mostrarArchivosGuardados() throws ExceptionNoHayArchivosGuardados{
		ArrayList<String> nombresArchivos = NombreArchivosGuardados.nombreArchivosGuardados();
		int numArch = 1;
		if (nombresArchivos.isEmpty()) {
			throw new ExceptionNoHayArchivosGuardados("No hay ningun archivo guardado");
		} else {
			for (int i = 0; i < nombresArchivos.size(); i++) {
				System.out.println("\tPartidas Guardadas");
				System.out.println("\n\n "+numArch+" - "+nombresArchivos.get(i));
				numArch++;
				}
			}
			
	}
	
	public String buscarNombreArchi(int posArchi) {
		ArrayList<String> nombresArchivos = NombreArchivosGuardados.nombreArchivosGuardados();
		
		return  nombresArchivos.get(posArchi);
	}
	
}
