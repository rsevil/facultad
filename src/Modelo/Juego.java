package Modelo;

import java.util.*;

import Modelo.Fabricas.*;

public class Juego {
	private Collection<Partida> partidas;
	
	private int anchoPantalla;
	private int altoPantalla;
	
	private Collection<Map.Entry<Integer,FabricaAnimal>> fabricasAnimales;
	private Collection<Map.Entry<Integer,FabricaElemento>> fabricasElementos;
	private Collection<Map.Entry<Integer,FabricaContexto>> fabricasContextos;
	private Collection<Map.Entry<Integer,FabricaMovimiento>> fabricasMovimientos;
	
	public Juego(int anchoPantalla, int altoPantalla){
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
		this.partidas = new ArrayList<Partida>();
		
		//configuro las fabricas de animales
		this.fabricasAnimales = new ArrayList<Map.Entry<Integer, FabricaAnimal>>();
		this.fabricasAnimales.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaAnimal>(1, new FabricaAnimalAve()));
		this.fabricasAnimales.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaAnimal>(2, new FabricaAnimalReptil()));
		this.fabricasAnimales.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaAnimal>(3, new FabricaAnimalMamifero()));
		
		//configuro las fabricas de elementos
		this.fabricasElementos = new ArrayList<Map.Entry<Integer, FabricaElemento>>();
		this.fabricasElementos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaElemento>(1, new FabricaElementoVerdura()));
		this.fabricasElementos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaElemento>(2, new FabricaElementoFruta()));
		this.fabricasElementos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaElemento>(3, new FabricaElementoCarne()));
		this.fabricasElementos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaElemento>(4, new FabricaElementoAsteroide()));
		this.fabricasElementos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaElemento>(5, new FabricaElementoEstrella()));
		this.fabricasElementos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaElemento>(6, new FabricaElementoLata()));
		this.fabricasElementos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaElemento>(7, new FabricaElementoLadrillo()));
		
		//configuro las fabricas de contextos
		this.fabricasContextos = new ArrayList<Map.Entry<Integer, FabricaContexto>>();
		this.fabricasContextos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaContexto>(1, new FabricaContextoAire()));
		this.fabricasContextos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaContexto>(2, new FabricaContextoTierra()));
		this.fabricasContextos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaContexto>(3, new FabricaContextoAgua()));
		
		//configuro las fabricas de movimientos
		this.fabricasMovimientos = new ArrayList<Map.Entry<Integer, FabricaMovimiento>>();
		this.fabricasMovimientos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaMovimiento>(1, new FabricaMovimientoRecto()));
		this.fabricasMovimientos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaMovimiento>(2, new FabricaMovimientoDiagonal()));
		this.fabricasMovimientos.add(new AbstractMap.SimpleImmutableEntry<Integer,FabricaMovimiento>(3, new FabricaMovimientoZigzag()));
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
