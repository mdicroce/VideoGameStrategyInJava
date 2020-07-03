package gamePrincipal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import Jugadores.Jugador;
import Mapa.Celda;
import Mapa.CeldaOcupadaException;
import Mapa.MapaTablero;
import Unidades.Unidad;
import grafics.ConvertidorDeTexto;
import grafics.CuadroTextoG;
import grafics.Cursor;
import grafics.Windows;
import mensajes.Textos;
import mensajes.apuntaAlVacio;
import mensajes.textoListaCuartel;

public class GameMain extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static JFrame window;
	private static Thread thread;
	private static Windows ventana;
	private static MapaTablero mapa;
	private static Cursor cursor;
	private static GameController teclado;
	public static byte estado;

	private static Partida nuevaPartida;
	public static CuadroTextoG textoG = null;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 640;
	private static Unidad unidad;
	private static volatile boolean enFuncionamiento = false;
	private int tick = 0;
	private static int x = 0;
	private static int y = 0;

	private static BufferedImage imagen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

	public GameMain(Partida partida) {
		this.estado = 0;
		mapa = new MapaTablero(10, 10, 32);
		ventana = new Windows(WIDTH, HEIGHT, mapa);
		cursor = new Cursor(ventana, mapa);
		teclado = new GameController();
		addKeyListener(teclado);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		nuevaPartida = partida;
		window = new JFrame("JavaWars");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLayout(new BorderLayout());
		window.add(this, BorderLayout.CENTER);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		nuevaPartida.getJugadorPorId(0).setTurno(true);
		nuevaPartida.getJugadorPorId(1).setTurno(false);
		cursor = new Cursor(ventana, mapa);
		cursor.setJugador(nuevaPartida.getJugadorxTurno());
		unidad = null;
	}

	public static void main(String[] args) {
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.menu();
	
		
	}

	public synchronized void iniciar() {
		enFuncionamiento = true;
		thread = new Thread(this, "Grafics");
		thread.start();
	}

	private synchronized void detener() {
		enFuncionamiento = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void actualizar() {
		/*if (this.textoG == null && estado == 0)
		{
			cursor.actualizar(teclado, mapa);
		}
		else if (textoG != null && estado == 0) {
			if(textoG.actualizar(teclado))
			{
				if (textoG.tipoDeOpcion == 0) {
					if (textoG.getSelected()==0) {
						textoG = new CuadroTextoG(new textoListaCuartel(nuevaPartida.getJugadorxTurno()));
					}
					else if(textoG.getSelected()==1) {
						nuevaPartida.pasarTurno();
					}
					else if(textoG.getSelected()==2) {
						System.out.println("Aca no se rinde nadie!!!");
					}
					else {
						textoG = null;
					}
				}

				else if(textoG.tipoDeOpcion == 4) {
					if (unidad == null) {
						unidad = nuevaPartida.getJugadorxTurno().buscarUnidadAlCuartel(textoG.getSelected());
						this.estado = 2;
					}
					
				}
				

			}
			
			
		}
		else if (estado == 2) {
			Celda auxCelda = cursor.actualizar(teclado, mapa, 0);
			if (auxCelda != null)
			{
				unidad.setPosicion(auxCelda);
				teclado.enter = false;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				textoG = null;
				estado = 0;
			}
		}*/ 
		demoJugable();
	}

	public static void moverCuartel() // PARA MOVERSE POR CUARTEL
	{

	}

	private void mostrar() {
		BufferStrategy estrategia = getBufferStrategy();
		if (estrategia == null) {
			createBufferStrategy(3);
			return;
		}
		mapa.mostrar(GameMain.ventana, 32);
		cursor.mostrar(ventana);
		if (textoG != null)
		{
			textoG.mostrar(ventana);
		}
		System.arraycopy(ventana.pixeles, 0, pixeles, 0, pixeles.length);
		Graphics g = estrategia.getDrawGraphics();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.dispose();

		requestFocus();

		estrategia.show();
	}

	/**
	 * Here we have the thread running, with 60 actualizaciones for second.
	 */
	public void run() {
		System.nanoTime();
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

		long referenciaActualizacion = System.nanoTime();
		double tiempoTranscurrido;
		double delta = 0;
		requestFocus();
		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime();

			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			while (delta >= 1) {
				actualizar();
				delta--;
			}
			mostrar();
		}
	}
	public void demoJugable()
	{
		tick++;
		if (tick == 60) {
			cursor.posicionX+=32;
		}
		if (tick == 120) {
			cursor.posicionY+=32;
		}
		
		if (tick == 180)
		{
			textoG = new CuadroTextoG(new apuntaAlVacio(nuevaPartida.getJugadorxTurno(), teclado)) ;
		}
		if (tick == 60*4) {
			textoG.selected++;
		}
		if (tick == 60*5)
		{
			textoG.selected++;
		}
		if (tick == 60*6)
		{
			textoG.selected--;
		}
		if (tick == 60*7)
		{
			textoG.selected--;
		}
		if(tick == 60*8)
		{
			textoG= new CuadroTextoG(new textoListaCuartel(nuevaPartida.getJugadorxTurno()));
		}
		if(tick == 60*9)
		{
			textoG.selected++;
		}
		if(tick == 60*10)
		{
			cursor.posicionX+=32;
		}
		if(tick == 60*11) {
			cursor.posicionY+=32;
		}
		if(tick == 60*12)
		{
			cursor.posicionY+=32;
		}
		if(tick == 60*13)
		{
			//nuevaPartida.getJugadorxTurno().buscarUnidadAlCuartel(1).setPosicion(mapa.getTablero()[(cursor.posicionX-cursor.posicionXaux)/32][(cursor.posicionY-cursor.posicionYaux)/32]);
			try {
				mapa.insertarUnidadTablero(nuevaPartida.getJugadorxTurno().buscarUnidadAlCuartel(1), mapa.getTablero()[(cursor.posicionX-cursor.posicionXaux)/32][(cursor.posicionY-cursor.posicionYaux)/32]);
			} catch (CeldaOcupadaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//nuevaPartida.getJugadorxTurno().eliminarUnidadAlCuartel(nuevaPartida.getJugadorxTurno().buscarUnidadAlCuartel(1));
			nuevaPartida.pasarTurno();
		}
		if(tick == 60*14)
		{
			cursor.posicionY+=32;
		}
		if(tick == 60*15)
		{
			textoG = new CuadroTextoG(new apuntaAlVacio(nuevaPartida.getJugadorxTurno(), teclado)) ;
		}
		if (tick == 60*16)
		{
			textoG.selected++;
		}
		if(tick== 60*17)
		{
			cursor.posicionX+=(32*7);
			cursor.posicionY+=(32*5);
		}
		if(tick == 60*18) {
			cursor.posicionX-=32;
		}
		if (tick == 60*19)
		{
			cursor.posicionY-=32;
		}
		if (tick == 60 * 20)
		{
			textoG = new CuadroTextoG(new apuntaAlVacio(nuevaPartida.getJugadorxTurno(), teclado)) ;
		}
		if (tick == 60*21) {
			textoG= new CuadroTextoG(new textoListaCuartel(nuevaPartida.getJugadorxTurno()));
		}
		if (tick == 60*22)
		{
			textoG.selected++;
			textoG.selected++;
		}
		if (tick == 60*23)
		{
			textoG.selected++;
			textoG.selected++;
		}
		if(tick == 60*24)
		{
			textoG.selected++;
			textoG.selected++;
		}
		if (tick == 60*25)
		{
			cursor.posicionX -=64;
		}
		if (tick == 60*26)
		{
			cursor.posicionX -= 64;
		}
		if (tick == 60 * 27)
		{
			cursor.posicionX-=64;
		}
		if (tick == 60*28)
		{
			cursor.posicionY -=64;
		}
		if (tick == 60*29)
		{
			try {
				mapa.insertarUnidadTablero(nuevaPartida.getJugadorxTurno().buscarUnidadAlCuartel(textoG.selected), mapa.getTablero()[(cursor.posicionX-cursor.posicionXaux)/32][(cursor.posicionY-cursor.posicionYaux)/32]);
			} catch (CeldaOcupadaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//nuevaPartida.getJugadorxTurno().eliminarUnidadAlCuartel(nuevaPartida.getJugadorxTurno().buscarUnidadAlCuartel(1));
			nuevaPartida.pasarTurno();
		}
		if (tick == 60*30)
		{
			cursor.posicionY -= 32*3;
		}
		if (tick == 60*31)
		{
			textoG.selected++;
		}
		if (tick == 60*32)
		{
			textoG.selected = 4;
		}
		if (tick == 60*33)
		{
			nuevaPartida.guardarPartida();
		}
			
		
	}
}