package Modelo;

public abstract class Objeto {

	protected Movimiento movimiento;
	protected Posicion posicion;
	protected int ancho;
	protected int alto;
	
	public Objeto(Movimiento movimiento, Posicion posicion, int ancho, int alto) {
		this.movimiento = movimiento;
		this.posicion = posicion;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public Objeto(Movimiento movimiento, Posicion posicion, int ancho){
		this(movimiento, posicion, ancho, ancho);
	}
	
	protected abstract float obtenerVX();
	
	protected abstract float obtenerVY();
	
	protected void mover(float deltaTiempo){
		this.posicion = 
				this.movimiento.calcularPosicion(
						this.obtenerVX(), 
						this.obtenerVY(), 
						deltaTiempo,  
						this.posicion.obtenerX(),
						this.posicion.obtenerX() + this.ancho,
						this.posicion.obtenerY(),
						this.posicion.obtenerY() + this.alto);
	}
}
