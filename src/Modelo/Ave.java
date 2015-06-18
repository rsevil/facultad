package Modelo;

public class Ave extends Animal {
	public Ave(Movimiento movimiento, Posicion posicion, Contexto contexto){
		super("ave.png", movimiento, posicion, contexto);
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
