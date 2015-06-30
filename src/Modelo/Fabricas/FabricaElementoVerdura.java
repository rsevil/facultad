package Modelo.Fabricas;

import Modelo.Elemento;
import Modelo.Movimiento;
import Modelo.Posicion;
import Modelo.Verdura;

public class FabricaElementoVerdura extends FabricaElemento {

	public Elemento crear(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje) {
		return new Verdura(movimiento,posicion,vx,vy,puntaje);
	}

}
