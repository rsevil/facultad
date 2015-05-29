package Modelo;

public class Reptil extends Animal {
	public int calcularDano(Elemento elemento) {
		return 1;
	}
	
	public void moverAnimal(int direccion, Contexto contexto) {
		int x = this.posicion.obtenerX(); 
		
		//Voy a la derecha
		if (direccion > 0){
			x = (int)(x + contexto.calcularVelocidad(this));			
		}else{
			x = (int)(x - contexto.calcularVelocidad(this));
		}
		this.posicion = new Posicion(x, this.posicion.obtenerY());
	}
	
	public boolean soyElAnimal(int tipoAnimal){
		return tipoAnimal == 2;
	}
}
