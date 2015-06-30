package Modelo;

public abstract class Movimiento {
	protected int anchoPantalla;
	protected int altoPantalla;
	
	protected float vx;
	protected float vy;
	
	Movimiento(int anchoPantalla, int altoPantalla){
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
	}
	
	abstract Posicion calcularPosicion(float vx, float vy, float deltaTiempo, float xi, float xf, float yi, float yf);
	
	protected float limites(float valor, float min, float max) {
		if (valor > max)
			return max;
		if (valor < min)
			return min;
		return valor;
	}
}
