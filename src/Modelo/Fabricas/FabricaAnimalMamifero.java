package Modelo.Fabricas;

import Modelo.Animal;
import Modelo.Contexto;
import Modelo.Mamifero;
import Modelo.Movimiento;
import Modelo.Posicion;

public class FabricaAnimalMamifero extends FabricaAnimal {

	public Animal Crear(Movimiento movimiento, Posicion posicion, Contexto contexto, float vidaInicial) {
		return new Mamifero(movimiento,posicion,contexto,vidaInicial);
	}

}
