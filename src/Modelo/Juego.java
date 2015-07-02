package Modelo;

import java.util.*;

import Modelo.Fabricas.*;

public class Juego {
	private Collection<Partida> partidas;
	
	private int anchoPantalla;
	private int altoPantalla;
	
	private Map<TipoAnimal,FabricaAnimal> fabricasAnimales;
	private Map<TipoElemento,FabricaElemento> fabricasElementos;
	private Map<TipoContexto,FabricaContexto> fabricasContextos;
	private Map<TipoMovimiento,FabricaMovimiento> fabricasMovimientos;
	
	public Juego(int anchoPantalla, int altoPantalla){
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
		this.partidas = new ArrayList<Partida>();
		
		//configuro las fabricas de animales
		this.fabricasAnimales = new HashMap<TipoAnimal, FabricaAnimal>();
		this.fabricasAnimales.put(TipoAnimal.ave, new FabricaAnimalAve());
		this.fabricasAnimales.put(TipoAnimal.reptil, new FabricaAnimalReptil());
		this.fabricasAnimales.put(TipoAnimal.mamifero, new FabricaAnimalMamifero());
		
		//configuro las fabricas de elementos
		this.fabricasElementos = new HashMap<TipoElemento, FabricaElemento>();
		this.fabricasElementos.put(TipoElemento.verdura, new FabricaElementoVerdura());
		this.fabricasElementos.put(TipoElemento.fruta, new FabricaElementoFruta());
		this.fabricasElementos.put(TipoElemento.carne, new FabricaElementoCarne());
		this.fabricasElementos.put(TipoElemento.asteroide, new FabricaElementoAsteroide());
		this.fabricasElementos.put(TipoElemento.estrella, new FabricaElementoEstrella());
		this.fabricasElementos.put(TipoElemento.lata, new FabricaElementoLata());
		this.fabricasElementos.put(TipoElemento.ladrillo, new FabricaElementoLadrillo());
		
		//configuro las fabricas de contextos
		this.fabricasContextos = new HashMap<TipoContexto, FabricaContexto>();
		this.fabricasContextos.put(TipoContexto.aire, new FabricaContextoAire());
		this.fabricasContextos.put(TipoContexto.tierra, new FabricaContextoTierra());
		this.fabricasContextos.put(TipoContexto.agua, new FabricaContextoAgua());
		
		//configuro las fabricas de movimientos
		this.fabricasMovimientos = new HashMap<TipoMovimiento, FabricaMovimiento>();
		this.fabricasMovimientos.put(TipoMovimiento.recto, new FabricaMovimientoRecto());
		this.fabricasMovimientos.put(TipoMovimiento.diagonal, new FabricaMovimientoDiagonal());
		this.fabricasMovimientos.put(TipoMovimiento.zigzag, new FabricaMovimientoZigzag());
		this.fabricasMovimientos.put(TipoMovimiento.lineal, new FabricaMovimientoLineal());
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
