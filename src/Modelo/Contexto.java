package Modelo;

public abstract class Contexto {
	public abstract float calcularVelocidad(Mamifero m);
	public abstract float calcularVelocidad(Ave a);
	public abstract float calcularVelocidad(Reptil r);
}
