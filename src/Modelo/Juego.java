package Modelo;

import java.util.*;

public class Juego {
	private Collection<Partida> partidas;
	
	public Partida nuevaPartida() {
		Partida p = new Partida();
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
