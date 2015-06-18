package Modelo;

public abstract class Animal extends EntidadMovil {
	protected float vida;
	protected Contexto contexto;
	private boolean derecha;
	private boolean izquierda;
	
	public Animal(Movimiento movimiento, Posicion posicion, Contexto contexto){
		super(movimiento, posicion, 4);
		this.contexto = contexto;
	}
	
	public void moverAnimal(float deltaTiempo, boolean derecha, boolean izquierda){
		this.izquierda = izquierda;
		this.derecha = derecha;
		this.mover(deltaTiempo);
	}
	
	protected abstract float calcularVelocidad();
	
	@Override
	protected float obtenerVX(){
		return this.transformarVelocidad(this.calcularVelocidad(), this.derecha, this.izquierda);
	}
	
	@Override
	protected float obtenerVY(){
		return this.transformarVelocidad(this.calcularVelocidad(), false, false);
	}
	
	public void calcularPuntaje(Elemento elemento){
		float xi = this.posicion.obtenerX();
		float xf = xi + this.ancho;
		float yi = this.posicion.obtenerY();
		float yf = yi + this.alto;
		
		if (elemento.ocupaCoordenadas(xi, xf, yi, yf))
			this.calcularVida(elemento);
	}
	
	protected abstract void calcularVida(Elemento elemento);
	
	public float obtenerVida() {
		return this.vida;
	}
	
	public boolean estoyMuerto() {
		return this.vida <= 0;
	}
	
	protected float transformarVelocidad(float vx, boolean positivo, boolean negativo){
		if (negativo)
			vx = -vx;
		
		//si no hay una tecla apretada, entonces ni siquiera 
		//se mueve a la velocidad que dice el contexto
		if (!positivo && !negativo 
				|| positivo && negativo)
			vx = 0;
		
		return vx;
	}
}
