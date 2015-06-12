package Modelo.Fabricas;

import Modelo.Movimiento;
import Modelo.Recto;

public class FabricaMovimientoRecto extends FabricaMovimiento {

	public Movimiento Crear(int anchoPantalla, int altoPantalla) {
		return new Recto(anchoPantalla,altoPantalla);
	}

}
