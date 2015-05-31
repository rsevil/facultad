package Modelo;

public class ConfiguracionElemento {
	private int tipoElemento;
	private float puntaje;
	public ConfiguracionElemento(int tipoElemento, int puntaje) {
		this.tipoElemento = tipoElemento;
		this.puntaje = puntaje;
	}
	
	public boolean soyParaElemento(int tipoElemento) {
		return this.tipoElemento == tipoElemento;
	}
	
	public float obtenerPuntaje() {
		return this.puntaje;
	}
}
