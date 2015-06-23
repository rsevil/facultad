package Presentacion;

import java.awt.Graphics2D;

public abstract class Graficable {

	protected Graphics2D graficos;
	protected float x;
	protected float y;
	
	public Graficable(Graphics2D graficos, float x, float y) {
		this.graficos = graficos;
		this.x = x;
		this.y = y;
	}
	
	public abstract void Graficar();
}
