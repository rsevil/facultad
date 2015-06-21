package Modelo;

public class Estrella extends Danino {
	public Estrella(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	float calcularDano(Mamifero m) {
		return super.puntaje*1.25f;
	}
	
	@Override
	float calcularDano(Ave a) {
		return super.puntaje;
	}
	
	@Override
	float calcularDano(Reptil r) {
		return super.puntaje*0.75f;
	}
}
