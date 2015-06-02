package Modelo;

public class Carne extends Benefico {
	public Carne(Movimiento movimiento, Posicion posicion, float puntaje, Dificultad dificultad){
		super(movimiento, posicion, puntaje, dificultad);
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
