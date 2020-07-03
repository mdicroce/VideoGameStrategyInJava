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
import Mapa.MapaTablero;
import grafics.ConvertidorDeTexto;
import grafics.CuadroTextoG;
import grafics.Cursor;
import grafics.Windows;
import mensajes.Textos;

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

	private static volatile boolean enFuncionamiento = false;

	private static int x = 0;
	private static int y = 0;

	private static BufferedImage imagen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

	private GameMain() {
		this.estado = 0;
		mapa = new MapaTablero(10, 10, 32);
		ventana = new Windows(WIDTH, HEIGHT, mapa);
		cursor = new Cursor(ventana, mapa);
		teclado = new GameController();
		addKeyListener(teclado);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		nuevaPartida = new Partida(100);
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
	}

	public static void main(String[] args) {
		GameMain jueguitos = new GameMain();
		jueguitos.iniciar();
	}

	private synchronized void iniciar() {
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
		if (this.textoG == null)
		{
			cursor.actualizar(teclado, mapa);
		}
		else if (textoG != null) {
			textoG.actualizar(teclado);
			
		}
		else if (estado == 2) {
			
		}
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
}