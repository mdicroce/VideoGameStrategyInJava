package Unidades;

import Mapa.Celda;
import grafics.Windows;
import maps.Maps;

public class GraficosUnidades {
	private String nombre;
	private double puntosVida;
	private double puntosAtaque;
	private double puntosDefensa;
	private int propiedad;
	private int id;
	private double costoOro;
	private Celda posicion;
	int pos1,pos2;
	public void mostrar(Windows pantalla) 
	{//ESTO va en la iniciación
		int pos1,pos2,pos3,pos4;
		if (this instanceof Caballero) {
			pos1 = 7; pos2 =17;
		}
		else if (this instanceof Arquero)
		{
			pos1 = 6; pos2 =16; 
		}
		else if(this instanceof Infanteria)
		{
			pos1 = 8; pos2 =18;
		}
		for (int y = 0; y < 64 ;y++) {
			for (int x = 0; x < 32;x++) {
				pantalla.pixeles[(x+posicion.getPosX()*32)+(y+posicion.getPosY()*32)*pantalla.sprites.getSize()]= pantalla.sprites.pixeles[pos2][x+y*pantalla.sprites.getSize()];
				pantalla.pixeles[(x+posicion.getPosX()*32)+((y-32)+posicion.getPosY()*32)*pantalla.sprites.getSize()] = pantalla.sprites.pixeles[pos1][x+y*pantalla.sprites.getSize()];
			}
		}
	}
	public void cargarSprite(Windows pantalla) 
	{
		
	}
	
}
