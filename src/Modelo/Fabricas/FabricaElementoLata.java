package Modelo.Fabricas;

import Modelo.Elemento;
import Modelo.Lata;
import Modelo.Movimiento;
import Modelo.Posicion;

public class FabricaElementoLata extends FabricaElemento {

	public Elemento Crear(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje) {
		return new Lata(movimiento,posicion,vx,vy,puntaje);
	}

}
