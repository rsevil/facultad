package Presentacion;

import Modelo.Dificultad;
import Modelo.TipoAnimal;
import Modelo.TipoContexto;

public class ComboBoxItem {
	
	private int valor;
	private String texto;
	
	public ComboBoxItem(int valor, String texto){
		this.valor = valor;
		this.texto = texto;
	}
	
	public ComboBoxItem(Dificultad dificultad){
		this(dificultad.obtenerValor(), dificultad.obtenerTexto());
	}
	
	public ComboBoxItem(TipoAnimal tipoAnimal){
		this(tipoAnimal.obtenerValor(), tipoAnimal.obtenerTexto());
	}
	
	public ComboBoxItem(TipoContexto tipoContexto){
		this(tipoContexto.obtenerValor(), tipoContexto.obtenerTexto());
	}
	
	public int obtenerValor(){
		return this.valor;
	}
	
	@Override
	public String toString(){
		return this.texto;
	}
}
