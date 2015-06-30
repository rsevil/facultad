package Modelo.Fabricas;

import Modelo.Elemento;
import Modelo.Ladrillo;
import Modelo.Movimiento;
import Modelo.Posicion;

public class FabricaElementoLadrillo extends FabricaElemento {

	public Elemento crear(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje) {
		return new Ladrillo(movimiento,posicion,vx,vy,puntaje);
	}

}
