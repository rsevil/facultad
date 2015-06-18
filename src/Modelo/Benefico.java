package Modelo;

public abstract class Benefico extends Elemento {
	public Benefico(String imageName, Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje){
		super(imageName, movimiento, posicion, vx, vy, puntaje);
	}

	@Override
	public float calcularPuntaje(Mamifero m){
		return calcularBeneficio(m);
	}
	
	@Override
	public float calcularPuntaje(Ave a){
		return calcularBeneficio(a);
	}
	
	@Override
	public float calcularPuntaje(Reptil r){
		return calcularBeneficio(r);
	}
	
	public abstract float calcularBeneficio(Mamifero m);
	public abstract float calcularBeneficio(Ave a);
	public abstract float calcularBeneficio(Reptil r);
}
