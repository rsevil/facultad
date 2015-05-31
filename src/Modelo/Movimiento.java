package Modelo;

public abstract class Movimiento {
	public abstract Posicion calcularPosicion(float deltaTiempo, Posicion posicion, Dificultad dificultad);
}
