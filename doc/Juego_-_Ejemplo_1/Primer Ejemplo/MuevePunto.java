package com.uade.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MuevePunto extends JComponent {

	private final static int ANCHO = 768;

	private final static int ALTO = 384;

	private final static int DIAMETRO = 10;

	private float x, y;

	private float vx, vy;

	private boolean arriba, abajo, izquierda, derecha;

	public MuevePunto() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		x = 10;
		y = 20;
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) { //levanto las teclas presionadas
				actualiza(e.getKeyCode(), true);
			}

			public void keyReleased(KeyEvent e) {
				actualiza(e.getKeyCode(), false);
			}

			private void actualiza(int keyCode, boolean pressed) {
				switch (keyCode) {
				case KeyEvent.VK_UP:
					arriba = pressed;
					break;

				case KeyEvent.VK_DOWN:
					abajo = pressed;
					break;

				case KeyEvent.VK_LEFT:
					izquierda = pressed;
					break;

				case KeyEvent.VK_RIGHT:
					derecha = pressed;
					break;
				}
			}
		});
		setFocusable(true);
	}

	/**
	 * Calcula que el punto no haya pasado los limites del recuadro
	 * @param valor
	 * @param min
	 * @param max
	 * @return
	 */
	private float limites(float valor, float min, float max) {
		if (valor > max)
			return max;
		if (valor < min)
			return min;
		return valor;
	}

	private void fisica(float dt) {
		vx = 0;
		vy = 0;
		if (arriba)
			vy = -200; // tama–o de los pasos. Porque no lo pongo como constante?
		if (abajo)
			vy = 200;
		if (izquierda)
			vx = -200;
		if (derecha)
			vx = 200;
		x = limites(x + vx * dt, 0, ANCHO - DIAMETRO);
		y = limites(y + vy * dt, 0, ALTO - DIAMETRO);
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, ANCHO, ALTO);
		g.setColor(Color.RED);
		g.fillOval(Math.round(x), Math.round(y), DIAMETRO, DIAMETRO);
	}

	private void dibuja() throws Exception {
		paintImmediately(0, 0, ANCHO, ALTO);
	}

	/**
	 * Dos formas de actualizar.
	 * En este caso se utiliza un ciclo infinito, donde con cada ciclo se calcula el movimiento que tiene que hacer
	 * el punto y se dibuja nuevamente.
	 * No es la mejor opci—n porque con esto tenemos un ciclo corriendo todo el tiempo. Lo mejor es utilizar un timer que se
	 * ejecute cada cierto tiempo
	 * @throws Exception
	 */
	public void cicloPrincipalJuego() throws Exception {
		long tiempoViejo = System.nanoTime();
		while (true) {
			long tiempoNuevo = System.nanoTime();
			float dt = (tiempoNuevo - tiempoViejo) / 1000000000f;
			tiempoViejo = tiempoNuevo;
			fisica(dt);
			dibuja();
		}
	}

	public static void main(String[] args) throws Exception {
		JFrame jf = new JFrame("Punto");
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		jf.setResizable(false);
		MuevePunto ball = new MuevePunto();
		jf.getContentPane().add(ball);
		jf.pack();
		jf.setVisible(true);
		ball.cicloPrincipalJuego();
	}
}
