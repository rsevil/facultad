package Modelo;

public abstract class Animal {
	protected float vida;
	protected int diametro;
	
	protected Movimiento movimiento;
	protected Posicion posicion;
	protected Contexto contexto;
	
	public Animal(Movimiento movimiento, Posicion posicion, Contexto contexto){
		this.diametro = 10;
		this.movimiento = movimiento;
		this.posicion = posicion;
		this.contexto = contexto;
	}
	
	public abstract void moverAnimal(float deltaTiempo, boolean derecha, boolean izquierda);
	
	public abstract void calcularDano(Elemento elemento);
	
	public float obtenerVida() {
		return this.vida;
	}
	
	public boolean estoyMuerto() {
		return this.vida >= 0;
	}
	
	protected float transformarVelocidad(float vx, boolean derecha, boolean izquierda){
		if (izquierda)
			vx = -vx;
		
		//si no hay una tecla apretada, entonces ni siquiera 
		//se mueve a la velocidad que dice el contexto
		if (!derecha && !izquierda)
			vx = 0;
		
		return vx;
	}
}
