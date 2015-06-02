package Modelo;

import java.util.*;

public class Juego {
	private Collection<Partida> partidas;
	
	private int anchoPantalla;
	private int altoPantalla;
	
	public Juego(int anchoPantalla, int altoPantalla){
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
	}
	
	public Partida nuevaPartida() {
		Partida p = new Partida(this.anchoPantalla,this.altoPantalla);
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
