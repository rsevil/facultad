package Modelo;

public class Recto extends Movimiento {
	
	public Recto(int anchoPantalla, int altoPantalla){
		super(anchoPantalla, altoPantalla);	
	}

	@Override
	public Posicion calcularPosicion(float vx, float vy, float deltaTiempo, float xi, float xf, float yi, float yf) {
		return new Posicion(
				xi,
				limites(yi + vy * deltaTiempo, 0, this.altoPantalla - (yf - yi)));
	}
}
