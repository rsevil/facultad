package Modelo;

public class Agua extends Contexto {
	public float calcularVelocidad(Ave a) {
		return 0.5f;
	}
	
	public float calcularVelocidad(Mamifero m) {
		return 0.75f;
	}
	
	public float calcularVelocidad(Reptil r) {
		return 1;
	}
	
	public boolean soyElContexto(int tipoContexto){
		return tipoContexto == 0;
	}
}
