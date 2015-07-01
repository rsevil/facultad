package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectoTest {

	private int ancho = 75;
	private int alto = 75;
	
	private Recto crear(){
		return new Recto(ancho,alto);
	}
	
	@Test
	public void testRecto() {
		Recto sut = crear();
		
		assertEquals(ancho, sut.anchoPantalla);
		assertEquals(alto, sut.altoPantalla);
	}
	
	@Test
	public void testCalcularPosicion_NoSeMueveALaDerecha() {
		Recto sut = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(xi,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_NoSeMueveALaIzquierda() {
		Recto sut = crear();
		
		float dt = 1;
		float vx = -1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(xi,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_MoverParaAbajo() {
		Recto sut = crear();
		
		float dt = 1;
		float vx = 0;
		float vy = 1;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(yi+1,p.obtenerX(),2);
	}
	
	@Test
	public void testLimites_EntreLimites(){
		Recto sut = crear();
		
		float n = sut.limites(5, 0, 10);
		
		assertEquals(5, n, 2);
	}
	
	@Test
	public void testLimites_LimiteSuperior(){
		Recto sut = crear();
		
		float n = sut.limites(15, 0, 10);
		
		assertEquals(10, n, 2);
	}

	@Test
	public void testLimites_LimiteInferior(){
		Recto sut = crear();
		
		float n = sut.limites(2, 5, 10);
		
		assertEquals(5, n, 2);
	}

}
