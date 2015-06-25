package Modelo;

public enum Dificultad {
	facil(1,"Facil"),
	medio(2,"Medio"),
	dificil(3,"Dificil");
	
	private int valor;
	private String texto;
	
	private Dificultad(int valor, String texto){
		this.valor = valor;
		this.texto = texto;
	}
	
	public int obtenerValor(){
		return this.valor;
	}
	
	public String obtenerTexto(){
		return this.texto;
	}
	
	public static Dificultad obtenerDificultad(int valor) throws Exception{
		for(Dificultad d : Dificultad.values()){
			if (d.obtenerValor() == valor)
				return d;
		}
		throw new Exception("El valor no se puede mapear a una dificultad");
	}
}
