package Modelo;

public class Reptil extends Animal {
	public Reptil(Movimiento movimiento, Posicion posicion, Contexto contexto){
		super(movimiento, posicion, contexto);
	}
	
	@Override
	public void calcularVida(Elemento elemento) {
		this.vida += elemento.calcularPuntaje(this);
	}

	@Override
	protected float calcularVelocidad() {
		return this.contexto.calcularVelocidad(this);
	}
}
