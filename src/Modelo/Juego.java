package Modelo;

import java.util.*;

import Modelo.Fabricas.*;

public class Juego {
	private Collection<Partida> partidas;
	
	private int anchoPantalla;
	private int altoPantalla;
	
	private Map<Integer,FabricaAnimal> fabricasAnimales;
	private Map<Integer,FabricaElemento> fabricasElementos;
	private Map<Integer,FabricaContexto> fabricasContextos;
	private Map<Integer,FabricaMovimiento> fabricasMovimientos;
	
	public Juego(int anchoPantalla, int altoPantalla){
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
		this.partidas = new ArrayList<Partida>();
		
		//configuro las fabricas de animales
		this.fabricasAnimales = new HashMap<Integer, FabricaAnimal>();
		this.fabricasAnimales.put(1, new FabricaAnimalAve());
		this.fabricasAnimales.put(2, new FabricaAnimalReptil());
		this.fabricasAnimales.put(3, new FabricaAnimalMamifero());
		
		//configuro las fabricas de elementos
		this.fabricasElementos = new HashMap<Integer, FabricaElemento>();
		this.fabricasElementos.put(1, new FabricaElementoVerdura());
		this.fabricasElementos.put(2, new FabricaElementoFruta());
		this.fabricasElementos.put(3, new FabricaElementoCarne());
		this.fabricasElementos.put(4, new FabricaElementoAsteroide());
		this.fabricasElementos.put(5, new FabricaElementoEstrella());
		this.fabricasElementos.put(6, new FabricaElementoLata());
		this.fabricasElementos.put(7, new FabricaElementoLadrillo());
		
		//configuro las fabricas de contextos
		this.fabricasContextos = new HashMap<Integer, FabricaContexto>();
		this.fabricasContextos.put(1, new FabricaContextoAire());
		this.fabricasContextos.put(2, new FabricaContextoTierra());
		this.fabricasContextos.put(3, new FabricaContextoAgua());
		
		//configuro las fabricas de movimientos
		this.fabricasMovimientos = new HashMap<Integer, FabricaMovimiento>();
		this.fabricasMovimientos.put(1, new FabricaMovimientoRecto());
		this.fabricasMovimientos.put(2, new FabricaMovimientoDiagonal());
		this.fabricasMovimientos.put(3, new FabricaMovimientoZigzag());
		this.fabricasMovimientos.put(4, new FabricaMovimientoLineal());
	}
	
	public Partida nuevaPartida() {
		Partida p = new Partida(
				this.anchoPantalla,
				this.altoPantalla,
				this.fabricasAnimales,
				this.fabricasElementos,
				this.fabricasContextos,
				this.fabricasMovimientos);
		this.partidas.add(p);
		return p;
	}
	
	public Collection<Puntaje> obtenerPuntajes() {
		Collection<Puntaje> puntajes = new ArrayList<Puntaje>();
		
		for(Partida p : this.partidas)
			puntajes.add(p.obtenerPuntaje());
		
		return puntajes;
	}
}
