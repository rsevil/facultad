package Modelo;

public class Recto extends Movimiento {
	
	public Recto(int anchoPantalla, int altoPantalla){
		super(anchoPantalla, altoPantalla);	
	}
	
	public Posicion calcularPosicion(float vx, float vy, float deltaTiempo, int diametro, Posicion posicion) {
		return new Posicion(
				posicion.obtenerX(),
				limites(posicion.obtenerY() + vy * deltaTiempo, 0, this.altoPantalla - diametro));
	}
}
