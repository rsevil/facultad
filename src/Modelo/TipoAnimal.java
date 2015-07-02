package Modelo;

public enum TipoAnimal {
	ave(1,"Ave"),
	reptil(2,"Reptil"),
	mamifero(3,"Mamifero");
	
	private int valor;
	private String texto;
	
	private TipoAnimal(int valor, String texto){
		this.valor = valor;
		this.texto = texto;
	}
	
	public int obtenerValor(){
		return this.valor;
	}
	
	public String obtenerTexto(){
		return this.texto;
	}
	
	public static TipoAnimal obtenerTipoAnimal(int valor) throws Exception{
		for(TipoAnimal d : TipoAnimal.values()){
			if (d.obtenerValor() == valor)
				return d;
		}
		throw new Exception("El valor no se puede mapear a un tipo animal");
	}
}
