package Modelo.Fabricas;

import Modelo.Animal;
import Modelo.Contexto;
import Modelo.Movimiento;
import Modelo.Posicion;
import Modelo.Reptil;

public class FabricaAnimalReptil extends FabricaAnimal {

	public Animal Crear(Movimiento movimiento, Posicion posicion, Contexto contexto) {
		return new Reptil(movimiento,posicion,contexto);
	}

}
