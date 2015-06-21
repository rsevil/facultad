package Modelo;

public class Aire extends Contexto {
	
	@Override
	float calcularVelocidad(Mamifero m) {
		return (float)0.75;
	}
	
	@Override
	float calcularVelocidad(Ave a) {
		return (float)1;
	}
	
	@Override
	float calcularVelocidad(Reptil r) {
		return (float)0.5;
	}
}
