package Modelo;

public abstract class Animal {
	private String nombre;
	protected int velocidad;
	protected Posicion posicion; 
	
	public void nombrar(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract void moverAnimal(int direccion, Contexto contexto);
	
	public abstract int calcularDano(Elemento elemento);
	
	public abstract boolean soyElAnimal(int tipoAnimal);
}
