package Modelo;

public class Fruta extends Benefico {
	public Fruta(Movimiento movimiento, float puntaje){
		super(movimiento,puntaje);
	}
	
	public float calcularBeneficio(Mamifero m) {
		return super.puntaje*1.25f;
	}
	
	public float calcularBeneficio(Ave a) {
		return super.puntaje;
	}
	
	public float calcularBeneficio(Reptil r) {
		return super.puntaje*0.75f;
	}
}
