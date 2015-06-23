package Presentacion;

import java.awt.Graphics2D;

public class TextoGraficable extends Graficable {

	private String texto;
	
	public TextoGraficable(Graphics2D graficos, float x, float y, String texto) {
		super(graficos, x, y);
		this.texto = texto;
	}

	@Override
	public void Graficar() {
		this.graficos.drawString(this.texto, x, y);
	}

}
