package Presentacion;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Observable;

import javax.swing.*;

import Modelo.*;

public class PantallaPartida extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Partida partida;
	
	public PantallaPartida(Partida partida, int anchoPantalla, int altoPantalla) {
		this.partida = partida;
		this.setPreferredSize(new Dimension(anchoPantalla, altoPantalla));
		this.iniciarDirecciones();
		this.iniciarObservadores();
		this.setFocusable(true);
		
		new Thread(() -> {
			try {
				partida.iniciar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	private void iniciarDirecciones(){
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				actualiza(e.getKeyCode(), true);
			}

			public void keyReleased(KeyEvent e) {
				actualiza(e.getKeyCode(), false);
			}
			
			private void actualiza(int keyCode, boolean pressed) {
				switch (keyCode) {
					case KeyEvent.VK_LEFT:
						partida.asignarIzquierda(pressed);
						break;

					case KeyEvent.VK_RIGHT:
						partida.asignarDerecha(pressed);
						break;
				}
			}
		});
	}
	
	private void iniciarObservadores(){
		this.partida.addObserver((Observable obj, Object arg) -> {
			SwingUtilities.invokeLater(() -> {
				this.repaint();
			});
		});
	}

	public void paint(Graphics g){
		super.paint(g);
		
		
	}
}
