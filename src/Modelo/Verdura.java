package Modelo;

public class Verdura extends Benefico {
	public Verdura(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	float calcularBeneficio(Mamifero m) {
		return super.puntaje * Constantes.MULTIPLICADOR_PUNTAJE_ELEMENTO_BAJO;
	}
	
	@Override
	float calcularBeneficio(Ave a) {
		return super.puntaje * Constantes.MULTIPLICADOR_PUNTAJE_ELEMENTO_NORMAL;
	}
	
	@Override
	float calcularBeneficio(Reptil r) {
		return super.puntaje * Constantes.MULTIPLICADOR_PUNTAJE_ELEMENTO_ALTO;
	}
}
