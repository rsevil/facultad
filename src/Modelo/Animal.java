package Modelo;

public abstract class Animal {
	protected float vida;
	protected Posicion posicion;
	
	public abstract void moverAnimal(float deltaTiempo, boolean derecha, boolean izquierda, Contexto contexto);
	
	public abstract void calcularDano(Elemento elemento);
	
	public float obtenerVida() {
		return vida;
	}
	
	public boolean estoyMuerto() {
		return vida >= 0;
	}
}
