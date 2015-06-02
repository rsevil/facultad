package Modelo;

public class Vertical extends Movimiento {
	
	public Vertical(int anchoPantalla, int altoPantalla){
		super(anchoPantalla, altoPantalla);	
	}
	
	public Posicion calcularPosicion(float vx, float vy, float deltaTiempo, int diametro, Posicion posicion) {
		return new Posicion(
				posicion.obtenerX(),
				limites(posicion.obtenerY() + vy * deltaTiempo, 0, this.altoPantalla - diametro));
	}
}
