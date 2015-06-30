package Modelo;

public abstract class EntidadMovil {

	protected Movimiento movimiento;
	protected Posicion posicion;
	protected int ancho;
	protected int alto;
	
	protected Posicion posicionAnterior;
	
	EntidadMovil(Movimiento movimiento, Posicion posicion, int ancho, int alto) {
		this.movimiento = movimiento;
		this.posicion = posicion;
		this.ancho = ancho;
		this.alto = alto;
		
		this.posicionAnterior = posicion;
	}
	
	EntidadMovil(Movimiento movimiento, Posicion posicion, int ancho){
		this(movimiento, posicion, ancho, ancho);
	}
	
	protected abstract float obtenerVX();
	
	protected abstract float obtenerVY();
	
	void mover(float deltaTiempo){
		this.posicionAnterior = this.posicion;
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
	
	public boolean vaHaciaLaDerecha(){
		return this.posicion.obtenerX() - this.posicionAnterior.obtenerX() >= 0; 
	}
	
	public Posicion obtenerPosicion(){
		return this.posicion;
	}
	
	public int obtenerAncho(){
		return this.ancho;
	}
	
	public int obtenerAlto(){
		return this.alto;
	}
}
