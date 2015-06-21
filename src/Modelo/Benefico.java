package Modelo;

public abstract class Benefico extends Elemento {
	public Benefico(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	float calcularPuntaje(Mamifero m){
		return calcularBeneficio(m);
	}
	
	@Override
	float calcularPuntaje(Ave a){
		return calcularBeneficio(a);
	}
	
	@Override
	float calcularPuntaje(Reptil r){
		return calcularBeneficio(r);
	}
	
	abstract float calcularBeneficio(Mamifero m);
	abstract float calcularBeneficio(Ave a);
	abstract float calcularBeneficio(Reptil r);
}
