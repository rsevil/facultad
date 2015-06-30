package Modelo;

public class Ladrillo extends Danino {
	public Ladrillo(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(movimiento, posicion, vx, vy, puntaje, 44, 21);
	}

	@Override
	float calcularDano(Mamifero m) {
		return super.puntaje * Constantes.MULTIPLICADOR_PUNTAJE_ELEMENTO_BAJO;
	}
	
	@Override
	float calcularDano(Ave a) {
		return super.puntaje * Constantes.MULTIPLICADOR_PUNTAJE_ELEMENTO_ALTO;
	}
	
	@Override
	float calcularDano(Reptil r) {
		return super.puntaje * Constantes.MULTIPLICADOR_PUNTAJE_ELEMENTO_NORMAL;
	}
}
