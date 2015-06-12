package Modelo.Fabricas;

import Modelo.Carne;
import Modelo.Elemento;
import Modelo.Movimiento;
import Modelo.Posicion;

public class FabricaElementoCarne extends FabricaElemento {

	public Elemento Crear(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje) {
		return new Carne(movimiento,posicion,vx,vy,puntaje);
	}

}
