package Modelo;

public abstract class Benefico extends Elemento {
	public Benefico(Movimiento movimiento, Posicion posicion, float puntaje, Dificultad dificultad){
		super(movimiento, posicion, puntaje, dificultad);
	}
	
	public float calcularPuntaje(Mamifero m){
		return calcularBeneficio(m);
	}
	
	public float calcularPuntaje(Ave a){
		return calcularBeneficio(a);
	}
	
	public float calcularPuntaje(Reptil r){
		return calcularBeneficio(r);
	}
	
	public abstract float calcularBeneficio(Mamifero m);
	public abstract float calcularBeneficio(Ave a);
	public abstract float calcularBeneficio(Reptil r);
}
