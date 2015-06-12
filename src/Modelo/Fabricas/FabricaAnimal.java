package Modelo.Fabricas;

import Modelo.Animal;
import Modelo.Contexto;
import Modelo.Movimiento;
import Modelo.Posicion;

public abstract class FabricaAnimal {
	
	public abstract Animal Crear(Movimiento movimiento, Posicion posicion, Contexto contexto);
	
}
