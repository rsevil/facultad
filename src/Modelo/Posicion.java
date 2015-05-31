package Modelo;

public class Posicion {
	private float x;
	private float y;
	public Posicion(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float obtenerX() {
		return this.x;
	}
	
	public float obtenerY() {
		return this.y;
	}
}
