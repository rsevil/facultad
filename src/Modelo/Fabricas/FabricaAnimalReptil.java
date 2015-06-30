package Modelo.Fabricas;

import Modelo.Animal;
import Modelo.Contexto;
import Modelo.Movimiento;
import Modelo.Posicion;
import Modelo.Reptil;

public class FabricaAnimalReptil extends FabricaAnimal {

	public Animal crear(Movimiento movimiento, Posicion posicion, Contexto contexto, float vidaInicial) {
		return new Reptil(movimiento,posicion,contexto,vidaInicial);
	}

}
