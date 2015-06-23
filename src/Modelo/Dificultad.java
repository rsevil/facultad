package Modelo;

public enum Dificultad {
	facil(1),
	medio(2),
	dificil(3);
	
	private int valor;
	
	private Dificultad(int valor){
		this.valor = valor;
	}
	
	public int obtenerValor(){
		return this.valor;
	}
	
	public static Dificultad obtenerDificultad(int valor) throws Exception{
		for(Dificultad d : Dificultad.values()){
			if (d.obtenerValor() == valor)
				return d;
		}
		throw new Exception("El valor no se puede mapear a una dificultad");
	}
}
