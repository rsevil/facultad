package Modelo.Fabricas;

import Modelo.Elemento;
import Modelo.Estrella;
import Modelo.Movimiento;
import Modelo.Posicion;

public class FabricaElementoEstrella extends FabricaElemento {

	public Elemento Crear(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje) {
		return new Estrella(movimiento,posicion,vx,vy,puntaje);
	}

}
