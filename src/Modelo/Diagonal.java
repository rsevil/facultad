package Modelo;

public class Diagonal extends Movimiento {
	
	private boolean derecha;
	private boolean izquierda;
	
	public Diagonal(int anchoPantalla, int altoPantalla){
		super(anchoPantalla, altoPantalla);
		this.derecha = true;
		this.izquierda = false;
	}

	@Override
	public Posicion calcularPosicion(float vx, float vy, float deltaTiempo, float xi, float xf, float yi, float yf) {
		if (this.derecha && xf >= anchoPantalla){
			this.derecha = false;
			this.izquierda = true;
		}else if (this.izquierda && xi <= 0){
			this.izquierda = false;
			this.derecha = true;
		}
		
		if (izquierda)
			vx = -vx;
		
		return new Posicion(
				limites(xi + vx * deltaTiempo, 0, this.anchoPantalla - (xf - xi)),
				yi + vy * deltaTiempo);
	}
}
