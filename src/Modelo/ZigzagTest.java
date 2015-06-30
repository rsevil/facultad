package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZigzagTest {

	private int anchoPantalla = 75;
	private int altoPantalla = 75;
	
	private Zigzag crear(){
		return new Zigzag(anchoPantalla,altoPantalla);
	}
	
	@Test
	public void testZigzag() {
		Zigzag z = crear();
		
		assertEquals(anchoPantalla, z.anchoPantalla);
		assertEquals(altoPantalla, z.altoPantalla);
	}
	
	@Test
	public void testCalcularPosicion_VxPositiva_MoverALaDerecha() {
		Zigzag z = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = z.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(2,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_VxPositiva_MoverAIzquierda() {
		Zigzag z = crear();
		
		float dt = 1;
		float vx = -1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = z.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(0,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_VyPositiva_MoverParaAbajo() {
		Zigzag z = crear();
		
		float dt = 1;
		float vx = 0;
		float vy = 1;
		float xi = 1;
		float yi = 1;
		
		Posicion p = z.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(2,p.obtenerY(),2);
	}
	
	@Test
	public void testCalcularPosicion_VyPositiva_MoverParaArriba() {
		Zigzag z = crear();
		
		float dt = 1;
		float vx = 0;
		float vy = -1;
		float xi = 1;
		float yi = 1;
		
		Posicion p = z.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(0,p.obtenerY(),2);
	}
	
	@Test
	public void testCalcularPosicion_RebotaHaciaIzquierda(){
		Zigzag z = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = anchoPantalla-1;
		float yi = 1;
		
		Posicion p = z.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(anchoPantalla-1,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_RebotaHaciaDerecha(){
		Zigzag z = crear();
		
		float dt = 1;
		float vx = -1;
		float vy = 0;
		float xi = 0;
		float yi = 1;
		
		Posicion p = z.calcularPosicion(vx, vy, dt, xi, xi + 1, yi, yi + 1);
		
		assertEquals(1,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_VaHaciaDerechaLlegaMaximaCantidadDeFramesRebotaIzquierda(){
		Zigzag z = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = 0;
		float yi = 1;
		
		int i;
		for(i = 0; i < 60; i++){
			Posicion p = z.calcularPosicion(vx, vy, dt, xi, xi + 1, yi, yi+1);
			xi = p.obtenerX();
		}
		
		Posicion p = z.calcularPosicion(vx, vy, dt, xi, xi + 1, yi, yi+1);
		
		assertEquals(58, p.obtenerX(),2);
	}
	
	@Test
	public void testLimites_EntreLimites(){
		Zigzag z = crear();
		
		float n = z.limites(5, 0, 10);
		
		assertEquals(5, n, 2);
	}
	
	@Test
	public void testLimites_LimiteSuperior(){
		Zigzag z = crear();
		
		float n = z.limites(15, 0, 10);
		
		assertEquals(10, n, 2);
	}

	@Test
	public void testLimites_LimiteInferior(){
		Zigzag z = crear();
		
		float n = z.limites(2, 5, 10);
		
		assertEquals(5, n, 2);
	}
	
}
