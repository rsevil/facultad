package Modelo.Fabricas;

import Modelo.Elemento;
import Modelo.Movimiento;
import Modelo.Posicion;

public abstract class FabricaElemento {

	public abstract Elemento Crear(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje);
	
}
