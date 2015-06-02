package Modelo;

public abstract class Danino extends Elemento {
	public Danino(Movimiento movimiento, Posicion posicion, float puntaje, Dificultad dificultad){
		super(movimiento, posicion, puntaje, dificultad);
	}
	
	public float calcularPuntaje(Mamifero m){
		return -this.calcularDano(m);
	}
	
	public float calcularPuntaje(Ave a){
		return -this.calcularDano(a);
	}
	
	public float calcularPuntaje(Reptil r){
		return -this.calcularDano(r);
	}
	
	public abstract float calcularDano(Mamifero m);
	public abstract float calcularDano(Ave a);
	public abstract float calcularDano(Reptil r);
}
