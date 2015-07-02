package Modelo;

public enum TipoElemento {
	verdura(1),
	fruta(2),
	carne(3),
	asteroide(4),
	estrella(5),
	lata(6),
	ladrillo(7);
	
	private int valor;
	
	private TipoElemento(int valor){
		this.valor = valor;
	}
	
	public int obtenerValor(){
		return this.valor;
	}
	
	public static TipoElemento obtenerTipoElemento(int valor) throws Exception{
		for(TipoElemento d : TipoElemento.values()){
			if (d.obtenerValor() == valor)
				return d;
		}
		throw new Exception("El valor no se puede mapear a un tipo elemento");
	}
}
