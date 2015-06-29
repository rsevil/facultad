package Presentacion;

import java.awt.Font;
import java.awt.Graphics2D;

public class TextoGraficable extends Graficable {

	private String texto;
	private Font fuente;
	
	public TextoGraficable(Graphics2D graficos, float x, float y, String texto, Font fuente) {
		super(graficos, x, y);
		this.texto = texto;
		this.fuente = fuente;
	}

	@Override
	public void Graficar() {
		this.graficos.setFont(fuente);
		this.graficos.drawString(this.texto, x, y);
	}

}
