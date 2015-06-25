package Modelo;

public class Ave extends Animal {
	public Ave(Movimiento movimiento, Posicion posicion, Contexto contexto, float vidaInicial){
		super(movimiento, posicion, contexto, vidaInicial);
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
