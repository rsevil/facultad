package Modelo;

public class Lata extends Danino {
	public Lata(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super("lata.png", movimiento, posicion, vx, vy, puntaje);
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
