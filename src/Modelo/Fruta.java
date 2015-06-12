package Modelo;

public class Fruta extends Benefico {
	public Fruta(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	public float calcularBeneficio(Mamifero m) {
		return super.puntaje*1.25f;
	}
	
	@Override
	public float calcularBeneficio(Ave a) {
		return super.puntaje;
	}
	
	@Override
	public float calcularBeneficio(Reptil r) {
		return super.puntaje*0.75f;
	}
}
