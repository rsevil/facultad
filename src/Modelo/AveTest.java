package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AveTest {

	private Movimiento movimiento;
	private Posicion posicion;
	private Contexto contexto;
	private int vidaInicial;
	private Ave sut;
	
	@Test
	public void testAve() {
		movimiento = new Lineal(100,100);
		posicion = new Posicion(0,0);
		contexto = new Agua();
		vidaInicial = 10;
		
		sut = new Ave(movimiento, posicion, contexto, vidaInicial);
		
		assertEquals(movimiento, sut.movimiento);
		assertEquals(posicion, sut.posicion);
		assertEquals(contexto, sut.contexto);
		assertEquals(vidaInicial, sut.vida, 2);
	}
	
	@Test
	public void testVidaCero_Muerto(){
		movimiento = new Lineal(100,100);
		posicion = new Posicion(0,0);
		contexto = new Agua();
		vidaInicial = 10;
		
		sut = new Ave(movimiento, posicion, contexto, vidaInicial);
		
		sut.vida = 0;
		assertEquals(true, sut.estoyMuerto());
	}
	
	@Test
	public void testVidaMenorCero_Muerto(){
		movimiento = new Lineal(100,100);
		posicion = new Posicion(0,0);
		contexto = new Agua();
		vidaInicial = 10;
		
		sut = new Ave(movimiento, posicion, contexto, vidaInicial);
		
		sut.vida = -1;
		assertEquals(true, sut.estoyMuerto());
	}

	@Test
	public void testVidaMayorCero_Muerto(){
		movimiento = new Lineal(100,100);
		posicion = new Posicion(0,0);
		contexto = new Agua();
		vidaInicial = 10;
		
		sut = new Ave(movimiento, posicion, contexto, vidaInicial);
		
		sut.vida = 1;
		assertEquals(false, sut.estoyMuerto());
	}
	
	@Test
	public void testMoverMayorCero(){
		movimiento = new Diagonal(100,100);
		posicion = new Posicion(0,0);
		contexto = new Agua();
		vidaInicial = 10;
		
		sut = new Ave(movimiento, posicion, contexto, vidaInicial);
		
		sut.mover(1);
		assertEquals(posicion, sut.posicionAnterior);
		assertEquals(posicion.obtenerX()+1, sut.posicion.obtenerX(),2);
		assertEquals(posicion.obtenerY()+1, sut.posicion.obtenerY(),2);
	}
	
	@Test
	public void testMoverConCero(){
		movimiento = new Diagonal(100,100);
		posicion = new Posicion(0,0);
		contexto = new Agua();
		vidaInicial = 10;
		
		sut = new Ave(movimiento, posicion, contexto, vidaInicial);
		sut.mover(0);
		
		assertEquals(posicion, sut.posicionAnterior);
		assertEquals(posicion.obtenerX(), sut.posicion.obtenerX(),2);
		assertEquals(posicion.obtenerY(), sut.posicion.obtenerY(),2);
	}
	
	@Test
	public void testMoverVaHaciaDerecha(){
		movimiento = new Diagonal(100,100);
		posicion = new Posicion(0,0);
		contexto = new Agua();
		vidaInicial = 10;
		
		sut = new Ave(movimiento, posicion, contexto, vidaInicial);
		sut.asignarDerecha(true);
		sut.asignarIzquierda(false);
		sut.mover(1);
		
		assertEquals(true, sut.vaHaciaLaDerecha());
	}
	
	@Test
	public void testMoverVaHaciaIzquierda(){
		movimiento = new Diagonal(100,100);
		posicion = new Posicion(10,0);
		contexto = new Agua();
		vidaInicial = 10;
		
		sut = new Ave(movimiento, posicion, contexto, vidaInicial);
		sut.asignarDerecha(false);
		sut.asignarIzquierda(true);
		sut.mover(1);
		
		assertEquals(false, sut.vaHaciaLaDerecha());
	}
	
}
