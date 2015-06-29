package Presentacion;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javax.swing.*;

import Modelo.*;

public class PantallaPartida extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Partida partida;
	
	private Thread hiloPartida;
	
	public PantallaPartida(Partida partida, int anchoPantalla, int altoPantalla) {
		this.partida = partida;
		this.setPreferredSize(new Dimension(anchoPantalla, altoPantalla));
		this.iniciarDirecciones();
		this.iniciarObservadores();
		this.setFocusable(true);
	}
	
	public void iniciarPartida(){
		this.hiloPartida = new Thread(() -> {
			try {
				partida.iniciar();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.toString());
			}
		});
		this.hiloPartida.start();
	}
	
	public void cerrarPartida() throws InterruptedException{
		partida.deleteObservers();
		if (this.hiloPartida != null){
			partida.finalizar();
			this.hiloPartida.join();
		}
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
					JOptionPane.showMessageDialog(this, ex.toString());
				}
			});
		});
	}

	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		Font fuente = crearFuente(g2d,16);
		
		Collection<Graficable> graficables = new ArrayList<Graficable>();
		
		graficables.add(
				new IconoGraficable(
						g2d, 0, 0, 
						this.getWidth(), 
						this.getHeight(), 
						true,
						this.obtenerNombreImagen(partida.obtenerContexto())));

		Puntaje puntaje = partida.obtenerPuntaje();
		graficables.add(
				new TextoGraficable(
						g2d, 10, 16, String.format("Nombre: %s",puntaje.obtenerNombre()),fuente));
		
		graficables.add(
				new TextoGraficable(
						g2d, 10, 34, String.format("Puntaje: %.2f",puntaje.obtenerPuntos()),fuente));
		
		Animal animal = partida.obtenerAnimal();
		graficables.add(
				new TextoGraficable(
						g2d, 10, 52, String.format("Vida: %.2f",animal.obtenerVida()),fuente));
		
		graficables.add(crearGraficable(g2d, animal));
		
		for(Elemento e : partida.obtenerElementos())
			graficables.add(crearGraficable(g2d, e));
		
		if (this.partida.terminada()){
			String texto = "Fin de la partida!";
			Font fuenteFin = fuente.deriveFont(Font.BOLD, 32);
			graficables.add(
					new TextoGraficable(
							g2d, 
							(float)((this.getWidth()/2) - (g2d.getFontMetrics(fuenteFin).getStringBounds(texto, g2d).getWidth() / 2)), 
							(this.getHeight()/2), 
							"Fin de la partida!", 
							fuenteFin));
		}
		
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
				entidad.vaHaciaLaDerecha(),
				this.obtenerNombreImagen(entidad));
	}
	
	private String obtenerNombreImagen(Object o){
		return o.getClass().getName().replaceAll("Modelo.", "").toLowerCase() + ".png";
	}
	
	private Font crearFuente(Graphics2D g, int tamano){
		Font currentFont = g.getFont();
		
		Map<TextAttribute, Object> attrs = new HashMap<TextAttribute, Object>();
		
		attrs.put(TextAttribute.FAMILY, currentFont.getFamily());
		attrs.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
		attrs.put(TextAttribute.SIZE, tamano);
		
		return Font.getFont(attrs);
	}
}
