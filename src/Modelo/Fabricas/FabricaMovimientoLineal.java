package Modelo.Fabricas;

import Modelo.Lineal;
import Modelo.Movimiento;

public class FabricaMovimientoLineal extends FabricaMovimiento {

	public Movimiento Crear(int anchoPantalla, int altoPantalla) {
		return new Lineal(anchoPantalla,altoPantalla);
	}

}
