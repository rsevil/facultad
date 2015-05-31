package Modelo;

public class Estrella extends Danino {
	public Estrella(Movimiento movimiento, float puntaje){
		super(movimiento,puntaje);
	}
	
	public float calcularDano(Mamifero m) {
		return super.puntaje*1.25f;
	}
	
	public float calcularDano(Ave a) {
		return super.puntaje;
	}
	
	public float calcularDano(Reptil r) {
		return super.puntaje*0.75f;
	}
}
