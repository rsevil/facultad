package Modelo;

public abstract class Contexto {
	abstract float calcularVelocidad(Mamifero m);
	abstract float calcularVelocidad(Ave a);
	abstract float calcularVelocidad(Reptil r);
}
