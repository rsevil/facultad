package Modelo.Fabricas;

import Modelo.Animal;
import Modelo.Ave;
import Modelo.Contexto;
import Modelo.Movimiento;
import Modelo.Posicion;

public class FabricaAnimalAve extends FabricaAnimal {
	
	public Animal Crear(Movimiento movimiento, Posicion posicion, Contexto contexto, float vidaInicial) {
		return new Ave(movimiento,posicion,contexto,vidaInicial);
	}

}
