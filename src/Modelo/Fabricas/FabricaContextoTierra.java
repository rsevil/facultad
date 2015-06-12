package Modelo.Fabricas;

import Modelo.Tierra;
import Modelo.Contexto;

public class FabricaContextoTierra extends FabricaContexto {

	public Contexto Crear() {
		return new Tierra();
	}

}
