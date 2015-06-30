package Modelo.Fabricas;

import Modelo.Diagonal;
import Modelo.Movimiento;

public class FabricaMovimientoDiagonal extends FabricaMovimiento {

	public Movimiento crear(int anchoPantalla, int altoPantalla) {
		return new Diagonal(anchoPantalla,altoPantalla);
	}

}
