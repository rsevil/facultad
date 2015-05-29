package Modelo;

public class Aire extends Contexto {
	public float calcularVelocidad(Ave a) {
		return 1;
	}
	
	public float calcularVelocidad(Mamifero m) {
		return 0.75f;
	}
	
	public float calcularVelocidad(Reptil r) {
		return 0.5f;
	}
	
	public boolean soyElContexto(int tipoContexto){
		return tipoContexto == 1;
	}
}
