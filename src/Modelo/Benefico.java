package Modelo;

public abstract class Benefico extends Elemento {
	public abstract void calcularDano(Mamifero m);
	public abstract void calcularDano(Ave a);
	public abstract void calcularDano(Reptil r);
}
