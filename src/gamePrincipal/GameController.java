package gamePrincipal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {

	private final static int numeroTeclas = 120; // TODAS LAS TECLAS DEL TECLADO TIENEN UN VALOR (120, nro Aproximado)
	private final boolean[] teclas = new boolean[numeroTeclas];

	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
	public boolean enter;

	public void actualizar() {
		arriba = teclas[KeyEvent.VK_W];
		abajo = teclas[KeyEvent.VK_S];
		izquierda = teclas[KeyEvent.VK_A];
		derecha = teclas[KeyEvent.VK_D];
		enter = teclas[KeyEvent.VK_ENTER];
	}
	

	@Override
	public void keyPressed(KeyEvent arg0) { // TECLA PULSADA (MANTENER PULSADA)
		teclas[arg0.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) { // TECLA LIBERADA
		teclas[arg0.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) { // TECLA PULSADA Y LIBERADA (PULSAR Y SOLTAR LA TECLA)

	}

}
