package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinealTest {

	private int ancho = 75;
	private int alto = 75;
	
	private Lineal crear(){
		return new Lineal(ancho,alto);
	}
	
	@Test
	public void testLineal() {
		Lineal sut = crear();
		
		assertEquals(ancho, sut.anchoPantalla);
		assertEquals(alto, sut.altoPantalla);
	}
	
	@Test
	public void testCalcularPosicion_MoverALaDerecha() {
		Lineal sut = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(2,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_MoverALaIzquierda() {
		Lineal sut = crear();
		
		float dt = 1;
		float vx = -1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(0,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_NoSuperaElAncho() {
		Lineal sut = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = ancho-1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(ancho,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_NoBajaAMenosQueCero() {
		Lineal sut = crear();
		
		float dt = 1;
		float vx = -1;
		float vy = 0;
		float xi = 0;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(xi,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_VyPositiva_NoSeMueveParaAbajo() {
		Lineal sut = crear();
		
		float dt = 1;
		float vx = 0;
		float vy = 1;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(yi,p.obtenerY(),2);
	}

	@Test
	public void testCalcularPosicion_VyNegativa_NoSeMueveParaArriba() {
		Lineal sut = crear();
		
		float dt = 1;
		float vx = 0;
		float vy = -1;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(yi,p.obtenerY(),2);
	}
	
	@Test
	public void testLimites_EntreLimites(){
		Lineal sut = crear();
		
		float n = sut.limites(5, 0, 10);
		
		assertEquals(5, n, 2);
	}
	
	@Test
	public void testLimites_LimiteSuperior(){
		Lineal sut = crear();
		
		float n = sut.limites(15, 0, 10);
		
		assertEquals(10, n, 2);
	}

	@Test
	public void testLimites_LimiteInferior(){
		Lineal sut = crear();
		
		float n = sut.limites(2, 5, 10);
		
		assertEquals(5, n, 2);
	}
	
}
