package Modelo;

public abstract class Elemento {
	protected float puntaje;
	protected Movimiento movimiento;
	protected Posicion posicion;
	
	private float vx;
	private float vy;
	
	public Elemento(Movimiento movimiento, Posicion posicion, float puntaje, Dificultad dificultad) {
		this.movimiento = movimiento;
		this.puntaje = puntaje;
		this.posicion = posicion;
		this.vx = this.transformarVelocidad(100, dificultad);
		this.vy = this.transformarVelocidad(100, dificultad);
	}
	
	public abstract float calcularPuntaje(Mamifero m);
	
	public abstract float calcularPuntaje(Ave a);
	
	public abstract float calcularPuntaje(Reptil r);
	
	public void moverElemento(float deltaTiempo) {
		this.posicion = this.movimiento.calcularPosicion(this.vx, this.vy, deltaTiempo, 10, this.posicion);
	}
	
	public boolean ocupaCoordenadas(float x, float y) {
		return this.posicion.obtenerX() == x 
			&& this.posicion.obtenerY() == y;
	}
	
	protected float transformarVelocidad(float v, Dificultad dificultad){
		switch(dificultad){
		case dificil:
			v = v * 2;
			break;
		case facil:
			v = v / 2;
			break;
		default:
			break;
		}
		return v;
	}
}
