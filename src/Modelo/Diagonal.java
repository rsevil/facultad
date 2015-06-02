package Modelo;

public class Diagonal extends Movimiento {
	
	private boolean derecha;
	private boolean izquierda;
	
	public Diagonal(int anchoPantalla, int altoPantalla){
		super(anchoPantalla, altoPantalla);
		this.derecha = true;
		this.izquierda = false;
	}
	
	public Posicion calcularPosicion(float vx, float vy, float deltaTiempo, int diametro, Posicion posicion) {
		float xf = posicion.obtenerX() + diametro;
		if (this.derecha && xf >= anchoPantalla){
			this.derecha = false;
			this.izquierda = true;
		}else if (this.izquierda && xf <= anchoPantalla){
			this.derecha = false;
			this.izquierda = true;
		}
		
		if (izquierda)
			vx = -vx;
		
		return new Posicion(
				limites(posicion.obtenerX() + vx * deltaTiempo, 0, this.anchoPantalla - diametro),
				limites(posicion.obtenerY() + vy * deltaTiempo, 0, this.altoPantalla - diametro));
	}
}
