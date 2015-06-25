package Modelo;

public class Lata extends Danino {
	public Lata(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	float calcularDano(Mamifero m) {
		return super.puntaje * Constantes.MULTIPLICADOR_PUNTAJE_ELEMENTO_ALTO;
	}
	
	@Override
	float calcularDano(Ave a) {
		return super.puntaje * Constantes.MULTIPLICADOR_PUNTAJE_ELEMENTO_NORMAL;
	}
	
	@Override
	float calcularDano(Reptil r) {
		return super.puntaje * Constantes.MULTIPLICADOR_PUNTAJE_ELEMENTO_BAJO;
	}
}
