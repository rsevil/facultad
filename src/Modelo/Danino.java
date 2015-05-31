package Modelo;

public abstract class Danino extends Elemento {
	public Danino(Movimiento movimiento, float puntaje){
		super(movimiento, puntaje);
	}
	
	public float calcularPuntaje(Mamifero m){
		return -calcularDano(m);
	}
	
	public float calcularPuntaje(Ave a){
		return -calcularDano(a);
	}
	
	public float calcularPuntaje(Reptil r){
		return -calcularDano(r);
	}
	
	public abstract float calcularDano(Mamifero m);
	public abstract float calcularDano(Ave a);
	public abstract float calcularDano(Reptil r);
}
