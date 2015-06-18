package Modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class EntidadMovil {

	private Image icon;
	protected Movimiento movimiento;
	protected Posicion posicion;
	protected int ancho;
	protected int alto;
	
	public EntidadMovil(String imageName, Movimiento movimiento, Posicion posicion, int ancho, int alto) {
		this.icon = new ImageIcon(getClass().getResource(imageName)).getImage();
		this.movimiento = movimiento;
		this.posicion = posicion;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public EntidadMovil(String imageName, Movimiento movimiento, Posicion posicion, int ancho){
		this(imageName, movimiento, posicion, ancho, ancho);
	}
	
	protected abstract float obtenerVX();
	
	protected abstract float obtenerVY();
	
	protected void mover(float deltaTiempo){
		this.posicion = 
				this.movimiento.calcularPosicion(
						this.obtenerVX(), 
						this.obtenerVY(), 
						deltaTiempo,  
						this.posicion.obtenerX(),
						this.posicion.obtenerX() + this.ancho,
						this.posicion.obtenerY(),
						this.posicion.obtenerY() + this.alto);
	}
	
	public void dibujar(Graphics2D g2d) {
		g2d.drawImage(this.icon, (int)posicion.obtenerX(), (int)posicion.obtenerY(), this.ancho, this.alto, null);
	}
}
