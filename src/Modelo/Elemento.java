package Modelo;

public abstract class Elemento {
	protected Movimiento movimiento;
	private Posicion posicion;
	
	public Elemento(){
		this.posicion = new Posicion(0,0);
	}
	
	public void moverElemento(Dificultad dificultad) {
		this.posicion = movimiento.calcularPosicion(posicion, dificultad);
	}
	
	public void determinarMovimiento(Movimiento m) {
		this.movimiento = m; 
	}
	
	public abstract void calcularDano(Mamifero m);
	
	public abstract void calcularDano(Ave a);
	
	public abstract void calcularDano(Reptil r);
}
