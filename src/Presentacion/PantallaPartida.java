package Presentacion;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import javax.swing.ImageIcon;

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
				try{
					this.repaint();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(this, ex.getMessage());
				}
			});
		});
	}

	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g; 
		Collection<Graficable> graficables = new ArrayList<Graficable>();
		
		graficables.add(
				new IconoGraficable(
						g2d, 0, 0, 
						this.getWidth(), 
						this.getHeight(), 
						this.obtenerNombreImagen(partida.obtenerContexto())));
		
		Animal animal = partida.obtenerAnimal();
		Puntaje puntaje = partida.obtenerPuntaje();
		graficables.add(
				new TextoGraficable(
						g2d, 10, 10, 
						String.format(
								"%s - Vida: %.2f, Puntaje: %.2f", 
								puntaje.obtenerNombre(), 
								animal.obtenerVida(), 
								puntaje.obtenerPuntos())));
		
		graficables.add(crearGraficable(g2d, animal));
		
		for(Elemento e : partida.obtenerElementos())
			graficables.add(crearGraficable(g2d, e));
		
		for(Graficable gr : graficables)
			gr.Graficar();
	}
	
	private IconoGraficable crearGraficable(Graphics2D graficos, EntidadMovil entidad){
		return new IconoGraficable(
				graficos, 
				entidad.obtenerPosicion().obtenerX(), 
				entidad.obtenerPosicion().obtenerY(), 
				entidad.obtenerAncho(), 
				entidad.obtenerAlto(), 
				this.obtenerNombreImagen(entidad));
	}
	
	private String obtenerNombreImagen(Object o){
		return o.getClass().getName().replaceAll("Modelo.", "").toLowerCase() + ".png";
	}
}
