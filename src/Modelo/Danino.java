package Modelo;

public abstract class Danino extends Elemento {
	Danino(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje, int ancho, int alto){
		super(movimiento, posicion, vx, vy, puntaje, ancho, alto);
	}
	
	Danino(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	float calcularPuntaje(Mamifero m){
		return -this.calcularDano(m);
	}
	
	@Override
	float calcularPuntaje(Ave a){
		return -this.calcularDano(a);
	}
	
	@Override
	float calcularPuntaje(Reptil r){
		return -this.calcularDano(r);
	}
	
	abstract float calcularDano(Mamifero m);
	abstract float calcularDano(Ave a);
	abstract float calcularDano(Reptil r);
}
