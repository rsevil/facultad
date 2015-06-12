package Modelo.Fabricas;

import Modelo.Contexto;
import Modelo.Aire;

public class FabricaContextoAire extends FabricaContexto {

	public Contexto Crear() {
		return new Aire();
	}

}
