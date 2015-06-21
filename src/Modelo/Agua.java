package Modelo;

public class Agua extends Contexto {
	
	@Override
	float calcularVelocidad(Mamifero m) {
		return (float)0.5;
	}
	
	@Override
	float calcularVelocidad(Ave a) {
		return (float)1;
	}
	
	@Override
	float calcularVelocidad(Reptil r) {
		return (float)0.75;
	}
}
