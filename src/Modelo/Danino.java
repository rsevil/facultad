package Modelo;

public abstract class Danino extends Elemento {
	public Danino(String imageName, Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(imageName, movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	public float calcularPuntaje(Mamifero m){
		return -this.calcularDano(m);
	}
	
	@Override
	public float calcularPuntaje(Ave a){
		return -this.calcularDano(a);
	}
	
	@Override
	public float calcularPuntaje(Reptil r){
		return -this.calcularDano(r);
	}
	
	public abstract float calcularDano(Mamifero m);
	public abstract float calcularDano(Ave a);
	public abstract float calcularDano(Reptil r);
}
