package Modelo;

public class Asteroide extends Danino {
	public Asteroide(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	public float calcularDano(Mamifero m) {
		return super.puntaje*1.25f;
	}
	
	@Override
	public float calcularDano(Ave a) {
		return super.puntaje;
	}
	
	@Override
	public float calcularDano(Reptil r) {
		return super.puntaje*0.75f;
	}
}
