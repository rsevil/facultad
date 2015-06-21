package Modelo;

public class Fruta extends Benefico {
	public Fruta(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	float calcularBeneficio(Mamifero m) {
		return super.puntaje*1.25f;
	}
	
	@Override
	float calcularBeneficio(Ave a) {
		return super.puntaje;
	}
	
	@Override
	float calcularBeneficio(Reptil r) {
		return super.puntaje*0.75f;
	}
}
