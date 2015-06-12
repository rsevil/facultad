package Modelo.Fabricas;

import Modelo.Agua;
import Modelo.Contexto;

public class FabricaContextoAgua extends FabricaContexto {

	public Contexto Crear() {
		return new Agua();
	}

}
