package gamePrincipal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import grafics.Windows;
import maps.Maps;

public class GamePruebasPantalla extends Canvas implements Runnable
{

	private static final long serialVersionUID = 1L;
	private static JFrame window;
	private static Thread thread;
	private static Windows ventana;
	private static Maps mapa;
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 640;
	
	private static volatile boolean enFuncionamiento = false;
	
	private static int x = 0;
	private static int y = 0;
	
	private static BufferedImage imagen = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt)imagen.getRaster().getDataBuffer()).getData();
	
	private GamePruebasPantalla() 
	{
		ventana = new Windows(WIDTH,HEIGHT);
		
		mapa = new Maps(50,50);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window = new JFrame("Menem");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLayout(new BorderLayout());
		window.add(this, BorderLayout.CENTER);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	public static void main(String[] args) 
	{
		GamePruebasPantalla jueguitos = new GamePruebasPantalla();
		jueguitos.iniciar();
	}
	private synchronized void iniciar()
	{
		enFuncionamiento = true;
		thread = new Thread(this,"Grafics");
		thread.start();
	}
	private synchronized void detener()
	{
		enFuncionamiento = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void actualizar() 
	{
		
	}
	private void mostrar()
	{
		BufferStrategy estrategia = getBufferStrategy();
		if (estrategia == null)
		{
			createBufferStrategy(3);
			return;
		}
		mapa.mostrar(x, y, ventana, 50, 50);
		
		System.arraycopy(ventana.pixeles, 0, pixeles, 0, pixeles.length);
		Graphics g = estrategia.getDrawGraphics();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		
		estrategia.show();
	}

	/**
	 * Here we have the thread running, with 60 actualizaciones for second. 
	 */
	public void run() 
	{
		System.nanoTime();
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long referenciaActualizacion = System.nanoTime();
		double tiempoTranscurrido;
		double delta = 0;
		
		while (enFuncionamiento)
		{
			final long inicioBucle = System.nanoTime();
			
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			
			delta+= tiempoTranscurrido / NS_POR_ACTUALIZACION;
			while (delta >= 1)
			{
				actualizar();
				delta--;
			}
			 
			mostrar();
		}
	}
}
