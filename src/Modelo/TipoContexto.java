package Modelo;

public enum TipoContexto {
	aire(1,"Aire"),
	tierra(2,"Tierra"),
	agua(3,"Agua");
	
	private int valor;
	private String texto;
	
	private TipoContexto(int valor, String texto){
		this.valor = valor;
		this.texto = texto;
	}
	
	public int obtenerValor(){
		return this.valor;
	}
	
	public String obtenerTexto(){
		return this.texto;
	}
	
	public static TipoContexto obtenerTipoContexto(int valor) throws Exception{
		for(TipoContexto d : TipoContexto.values()){
			if (d.obtenerValor() == valor)
				return d;
		}
		throw new Exception("El valor no se puede mapear a un tipo contexto");
	}
}
