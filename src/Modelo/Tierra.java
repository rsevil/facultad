package Modelo;

public class Tierra extends Contexto {
	
	@Override
	public float calcularVelocidad(Mamifero m) {
		return (float)1;
	}

	@Override
	public float calcularVelocidad(Ave a) {
		return (float)0.5;
	}
	
	@Override
	public float calcularVelocidad(Reptil r) {
		return (float)0.75;
	}
}
