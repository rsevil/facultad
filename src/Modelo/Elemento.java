package Modelo;

public abstract class Elemento {
	protected float puntaje;
	protected Movimiento movimiento;
	protected Posicion posicion;
	
	public Elemento(Movimiento movimiento, float puntaje) {
		this.movimiento = movimiento;
		this.puntaje = puntaje;
		this.posicion = new Posicion(0,0);
	}
	
	public abstract float calcularPuntaje(Mamifero m);
	
	public abstract float calcularPuntaje(Ave a);
	
	public abstract float calcularPuntaje(Reptil r);
	
	public void moverElemento(float deltaTiempo, Dificultad dificultad) {
		this.posicion = this.movimiento.calcularPosicion(deltaTiempo, this.posicion, dificultad);
	}
	
	public boolean ocupaCoordenadas(int x, int y) {
		return this.posicion.obtenerX() == x 
			&& this.posicion.obtenerY() == y;
	}
}
