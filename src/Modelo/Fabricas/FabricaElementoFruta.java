package Modelo.Fabricas;

import Modelo.Elemento;
import Modelo.Fruta;
import Modelo.Movimiento;
import Modelo.Posicion;

public class FabricaElementoFruta extends FabricaElemento {

	public Elemento Crear(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje) {
		return new Fruta(movimiento,posicion,vx,vy,puntaje);
	}

}
