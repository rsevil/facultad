package Modelo;

public class Tierra extends Contexto {
	public float calcularVelocidad(Mamifero m) {
		return (float)1;
	}
	
	public float calcularVelocidad(Ave a) {
		return (float)0.5;
	}
	
	public float calcularVelocidad(Reptil r) {
		return (float)0.75;
	}
}
