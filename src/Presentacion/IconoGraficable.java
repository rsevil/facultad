package Presentacion;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class IconoGraficable extends Graficable {
	private int ancho;
	private int alto;
	private Image image;
	
	public IconoGraficable(Graphics2D graficos, float x, float y, int ancho, int alto, String nombreImagen) {
		super(graficos, x, y);
		this.ancho = ancho;
		this.alto = alto;
		this.image = new ImageIcon(getClass().getResource("imgs//" + nombreImagen)).getImage();
	}
	
	@Override
	public void Graficar(){
		graficos.drawImage(image, (int)x, (int)y, ancho, alto, null);
	}

}
