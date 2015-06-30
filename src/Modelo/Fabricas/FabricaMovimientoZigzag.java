package Modelo.Fabricas;

import Modelo.Movimiento;
import Modelo.Zigzag;

public class FabricaMovimientoZigzag extends FabricaMovimiento {

	public Movimiento crear(int anchoPantalla, int altoPantalla) {
		return new Zigzag(anchoPantalla,altoPantalla);
	}

}
