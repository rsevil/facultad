package Modelo;

public class Ave extends Animal {
	public void moverAnimal(float deltaTiempo, boolean derecha, boolean izquierda, Contexto contexto) {
		//TODO:Calcular posicion animal
	}
	
	public void calcularDano(Elemento elemento) {
		this.vida = elemento.calcularPuntaje(this);
	}
}
