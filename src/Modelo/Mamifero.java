package Modelo;

public class Mamifero extends Animal {
	public Mamifero(Movimiento movimiento, Posicion posicion, Contexto contexto){
		super(movimiento, posicion, contexto);
	}
	
	public void moverAnimal(float deltaTiempo, boolean derecha, boolean izquierda) {
		float vx = this.transformarVelocidad(this.contexto.calcularVelocidad(this), derecha, izquierda);
		float vy = 0;
		this.posicion = this.movimiento.calcularPosicion(vx, vy, deltaTiempo, this.diametro, this.posicion);
	}
	
	public void calcularDano(Elemento elemento) {
		if (elemento.ocupaCoordenadas(this.posicion.obtenerX(), this.posicion.obtenerY()))
			this.vida += elemento.calcularPuntaje(this);
	}
}
