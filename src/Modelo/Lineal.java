package Modelo;

public class Lineal extends Movimiento {

	public Lineal(int anchoPantalla, int altoPantalla) {
		super(anchoPantalla, altoPantalla);
	}

	@Override
	public Posicion calcularPosicion(float vx, float vy, float deltaTiempo, float xi, float xf, float yi, float yf) {
		return new Posicion(
				limites(xi + vx * deltaTiempo, 0, this.anchoPantalla - (xf - xi)), 
				yi);
	}

}
