package Presentacion;

public class ComboBoxItem {
	
	int valor;
	String texto;
	
	public ComboBoxItem(int valor, String texto){
		this.valor = valor;
		this.texto = texto;
	}
	
	public int obtenerValor(){
		return this.valor;
	}
}
