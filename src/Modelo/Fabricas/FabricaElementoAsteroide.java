package Modelo.Fabricas;

import Modelo.Asteroide;
import Modelo.Elemento;
import Modelo.Movimiento;
import Modelo.Posicion;

public class FabricaElementoAsteroide extends FabricaElemento {
	
	public Elemento crear(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje) {
		return new Asteroide(movimiento,posicion,vx,vy,puntaje);
	}

}
