package Modelo;

public class Puntaje {
	private String nombre;
	private String animal;
	private float puntos;
	Puntaje(String nombre, String animal, float puntos) {
		this.nombre = nombre;
		this.animal = animal;
		this.puntos = puntos;
	}
	
	public String obtenerNombre() {
		return this.nombre;
	}
	
	public String obtenerAnimal() {
		return this.animal;
	}
	
	public float obtenerPuntos() {
		return this.puntos;
	}
}
