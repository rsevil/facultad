package Modelo;

public class Puntaje {
	private String nombre;
	private float puntos;
	public Puntaje(String nombre, float puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
	public String obtenerNombre() {
		return this.nombre;
	}
	
	public float obtenerPuntos() {
		return this.puntos;
	}
}
