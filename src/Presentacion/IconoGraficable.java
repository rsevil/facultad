package Presentacion;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class IconoGraficable extends Graficable {
	private int ancho;
	private int alto;
	private Image image;
	private boolean miraDerecha;
	
	public IconoGraficable(Graphics2D graficos, float x, float y, int ancho, int alto, boolean miraDerecha, String nombreImagen) {
		super(graficos, x, y);
		this.ancho = ancho;
		this.alto = alto;
		this.miraDerecha = miraDerecha;
		this.image = new ImageIcon(getClass().getResource("imgs//" + nombreImagen)).getImage();
	}
	
	@Override
	public void Graficar(){
		if (miraDerecha){
			graficos.drawImage(image,(int)x,(int)y,ancho,alto,null);
		}else{
			graficos.drawImage(image,(int)x+ancho,(int)y,-ancho,alto,null);
		}
		
	}

}
