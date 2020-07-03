package gamePrincipal;

import java.util.ArrayList;
import java.util.Scanner;
import GuardadoYCarga.ExceptionNoHayArchivosGuardados;
import GuardadoYCarga.NombreArchivosGuardados;


/**
 * En esta clase se encuentran los metodos que utilizara el MenuPrincipal para poder realizar las tareas de Cargar y Crear una partida.
 * @author Nahue
 *
 */
public class PantallaOpciones {
	
	/**
	 * Muestra las opciones del Menu principal
	 */
	public static void mostrarOpciones() {
		
		System.out.println("\tMenu Principal");
		System.out.println("\n 1 - Crear Partida Nueva");
		System.out.println(" 2 - Cargar Partida Guardada");
		System.out.println(" 0 - Salir");
			
	}
	
	/**
	 * Crea una nueva partida y la retorna.
	 * @return Objeto del tipo partida.
	 */
	public static Partida crearPartidaNueva() {
		
		Partida partida = new Partida(50);
		
		partida.crearNuevaPartida();
		
		return partida;
	}
	
	/**
	 * Carga una partida y la retorna.
	 * @param nombreArchi String que contiene la direccion del Archivo.
	 * @return Objeto del tipo partida.
	 */
	public static Partida cargarPartidaGuardada(String nombreArchi) {
		
		Partida partida = new Partida();
		
		partida.cargarPartida(nombreArchi);
		
		return partida;
	}
	
	/**
	 * Lee la opcion que el jugador ingresa por teclado.
	 * @return Un int que representa la opcion que desea el jugador.
	 */
	public static int leerOpcionTeclado() {
		int op;
		Scanner scan = new Scanner(System.in);		
		System.out.println("\n\tIngrese una opcion\n\t");
		op = scan.nextInt();
				
		scan.close();
		
		return op;
	}
	
	/**
	 * Muestra todas las partidas guardadas.
	 * @throws ExceptionNoHayArchivosGuardados Es lanzada cuando no hay ningun archivo guardado.
	 */
	public static void mostrarArchivosGuardados() throws ExceptionNoHayArchivosGuardados{
		ArrayList<String> nombresArchivos = NombreArchivosGuardados.nombreArchivosGuardados();
		int numArch = 1;
		if (nombresArchivos.isEmpty()) {
			throw new ExceptionNoHayArchivosGuardados("No hay ningun archivo guardado.");
		} else {
			System.out.println("\n\n\n\n\n\tPartidas Guardadas\n\n");
			
			for (int i = 0; i < nombresArchivos.size(); i++) {
				
				System.out.println(numArch+" - "+nombresArchivos.get(i));
				numArch++;
				}
			}
	}
	
	/**
	 * Busca en el ArrayList el nombre del archivo deseado por el usuario y lo retorna.
	 * @param posArchi Un int que es la posicion del nombre del archivo exedido por un numero.
	 * @return Un String que es el nombre del archivo a cargar.
	 */
	
	public static String buscarNombreArchi(int posArchi) {
		ArrayList<String> nombresArchivos = NombreArchivosGuardados.nombreArchivosGuardados();
		int pos = posArchi-1;
		
		return  nombresArchivos.get(pos);
	}
	
}
