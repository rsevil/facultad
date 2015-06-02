package Modelo;

public class Lineal extends Movimiento {

	public Lineal(int anchoPantalla, int altoPantalla) {
		super(anchoPantalla, altoPantalla);
	}

	public Posicion calcularPosicion(float vx, float vy, float deltaTiempo, int diametro, Posicion posicion) {
		return new Posicion(
				limites(posicion.obtenerX() + vx * deltaTiempo, 0, this.anchoPantalla - diametro),
				posicion.obtenerY());
	}

}
