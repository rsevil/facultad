package Modelo;

public class Mamifero extends Animal {
	public Mamifero(Movimiento movimiento, Posicion posicion, Contexto contexto){
		super("mamifero.png", movimiento, posicion, contexto);
	}
	
	@Override
	protected void calcularVida(Elemento elemento) {
		this.vida += elemento.calcularPuntaje(this);
	}

	@Override
	protected float calcularVelocidad() {
		return this.contexto.calcularVelocidad(this);
	}
}
