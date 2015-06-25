package Presentacion;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
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
	}
	
	public void iniciarPartida(){
		new Thread(() -> {
			try {
				partida.iniciar();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
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
		
		Collection<Graficable> graficables = new ArrayList<Graficable>();
				
		//graficables.add(new IconoGraficable((Graphics2D)g, 0, 0, this.getSize().width, this.getSize().height, partida.obtenerContexto().getClass().getName()));
		
		Animal animal = partida.obtenerAnimal();
		Puntaje puntaje = partida.obtenerPuntaje();
		graficables.add(new TextoGraficable((Graphics2D)g, 10, 10, String.format("%s - Vida: %.0f, Puntaje: %.2f", puntaje.obtenerNombre(), animal.obtenerVida(), puntaje.obtenerPuntos())));
		
		for(Elemento e : partida.obtenerElementos())
			graficables.add(crearGraficable(g, e));
		
		graficables.add(crearGraficable(g, animal));
		
		for(Graficable gr : graficables)
			gr.Graficar();
	}
	
	private IconoGraficable crearGraficable(Graphics graficos, EntidadMovil entidad){
		return new IconoGraficable(
				(Graphics2D)graficos, 
				entidad.obtenerPosicion().obtenerX(), 
				entidad.obtenerPosicion().obtenerY(), 
				entidad.obtenerAncho(), 
				entidad.obtenerAlto(), 
				entidad.getClass().getName());
	}
}
