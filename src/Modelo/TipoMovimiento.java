package Modelo;

public enum TipoMovimiento {
	recto(1),
	diagonal(2),
	zigzag(3),
	lineal(4);
	
	private int valor;
	
	private TipoMovimiento(int valor){
		this.valor = valor;
	}
	
	public int obtenerValor(){
		return this.valor;
	}
	
	public static TipoMovimiento obtenerTipoMovimiento(int valor) throws Exception{
		for(TipoMovimiento d : TipoMovimiento.values()){
			if (d.obtenerValor() == valor)
				return d;
		}
		throw new Exception("El valor no se puede mapear a un tipo movimiento");
	}
}
