package gamePrincipal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GamePruebasPantalla extends Canvas
{

	private static final long serialVersionUID = 1L;
	private static JFrame window;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 640;
	private GamePruebasPantalla() {
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

public static void main(String[] args) {
	GamePruebasPantalla jueguitos = new GamePruebasPantalla();
}
}
