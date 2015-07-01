package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiagonalTest {

	private int ancho = 75;
	private int alto = 75;
	
	private Diagonal crear(){
		return new Diagonal(ancho,alto);
	}
	
	@Test
	public void testDiagonal() {
		Diagonal sut = crear();
		
		assertEquals(ancho, sut.anchoPantalla);
		assertEquals(alto, sut.altoPantalla);
	}
	
	@Test
	public void testCalcularPosicion_VxPositiva_MoverALaDerecha() {
		Diagonal sut = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(2,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_VxPositiva_MoverAIzquierda() {
		Diagonal sut = crear();
		
		float dt = 1;
		float vx = -1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(0,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_VyPositiva_MoverParaAbajo() {
		Diagonal sut = crear();
		
		float dt = 1;
		float vx = 0;
		float vy = 1;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(2,p.obtenerY(),2);
	}
	
	@Test
	public void testCalcularPosicion_VyNegativa_MoverParaArriba() {
		Diagonal sut = crear();
		
		float dt = 1;
		float vx = 0;
		float vy = -1;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(0,p.obtenerY(),2);
	}
	

	@Test
	public void testCalcularPosicion_RebotaHaciaIzquierda(){
		Diagonal sut = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = ancho-1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(ancho-1,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_RebotaHaciaDerecha(){
		Diagonal sut = crear();
		
		float dt = 1;
		float vx = -1;
		float vy = 0;
		float xi = 0;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi + 1, yi, yi + 1);
		
		assertEquals(1,p.obtenerX(),2);
	}
	
		
	@Test
	public void testLimites_EntreLimites(){
		Diagonal sut = crear();
		
		float n = sut.limites(5, 0, 10);
		
		assertEquals(5, n, 2);
	}
	
	@Test
	public void testLimites_LimiteSuperior(){
		Diagonal sut = crear();
		
		float n = sut.limites(15, 0, 10);
		
		assertEquals(10, n, 2);
	}

	@Test
	public void testLimites_LimiteInferior(){
		Diagonal sut = crear();
		
		float n = sut.limites(2, 5, 10);
		
		assertEquals(5, n, 2);
	}

}
