package Modelo;

import java.util.*;

public class Partida {
	private String nombre;
	private Dificultad dificultad;
	private float puntajeAcumulado;
	private int frames;
	
	private Animal animal;
	private Contexto contexto;
	private Collection<ConfiguracionElemento> configuraciones;
	private Collection<Elemento> elementos;
	
	public void elegirNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void elegirAnimal(int tipoAnimal) {
		this.crearAnimal(tipoAnimal);
	}
	
	public void elegirContexto(int tipoContexto) {
		this.crearContexto(tipoContexto);
	}
	
	public void elegirDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	public void configurarElemento(int tipoElemento, int puntaje) {
		for(Iterator<ConfiguracionElemento> it = this.configuraciones.iterator(); it.hasNext();){
			ConfiguracionElemento ce = it.next();
			if (ce.soyParaElemento(tipoElemento)){
				it.remove();
				break;
			}
		}
		this.configuraciones.add(new ConfiguracionElemento(tipoElemento, puntaje));
	}
	
	public void frame(float deltaTiempo, boolean derecha, boolean izquierda) throws Exception {
		this.frames++;
		
		if (this.frames % 180 == 0 && this.elementos.size() < 10){
			//TODO: generar el tipoElemento al azar
			int tipoElemento = 1;
			this.crearElemento(tipoElemento);
		}
		
		this.animal.moverAnimal(deltaTiempo, derecha, izquierda, this.contexto);
		
		this.moverElementos(deltaTiempo);
		
		this.calcularDanos();
		
		this.calcularPuntaje();
	}
	
	public boolean terminada() {
		return this.animal.estoyMuerto();
	}
	
	public Puntaje obtenerPuntaje() {
		return new Puntaje(this.nombre, this.puntajeAcumulado);
	}
	
	private void crearAnimal(int tipoAnimal) {
		switch(tipoAnimal)
		{
			case 1: 
				this.animal = new Ave();
				break;
			case 2:
				this.animal = new Reptil();
				break;
			case 3:
				this.animal = new Mamifero();
				break;
		}
	}
	
	private void crearContexto(int tipoContexto) {
		switch(tipoContexto){
			case 1:
				this.contexto = new Aire();
				break;
			case 2:
				this.contexto = new Tierra();
				break;
			case 3:
				this.contexto = new Agua();
				break;
		}
	}
	
	private void crearElemento(int tipoElemento) throws Exception {
		float puntaje = 1;
		if (this.existeConfiguracionElemento(tipoElemento)){
			ConfiguracionElemento ce = this.obtenerConfiguracionElemento(tipoElemento);
			puntaje = ce.obtenerPuntaje();
		}
		
		Movimiento m = this.obtenerMovimiento();
		Elemento e = null;
		switch(tipoElemento)
		{
			case 1:
				e = new Verdura(m, puntaje);
				break;
			case 2:
				e = new Fruta(m, puntaje);
				break;
			case 3:
				e = new Carne(m, puntaje);
				break;
			case 4:
				e = new Asteroide(m, puntaje);
				break;
			case 5:
				e = new Estrella(m,puntaje);
				break;
			case 6:
				e = new Lata(m,puntaje);
				break;
			case 7:
				e = new Ladrillo(m,puntaje);
				break;
		}
		this.elementos.add(e);
	}
	
	private Movimiento obtenerMovimiento(){
		//TODO: obtener movimiento al azar
		return new Horizontal();
	}
	
	private boolean existeConfiguracionElemento(int tipoElemento) {
		for(ConfiguracionElemento ce : this.configuraciones){
			if (ce.soyParaElemento(tipoElemento))
				return true;
		}
		return false;
	}
	
	private ConfiguracionElemento obtenerConfiguracionElemento(int tipoElemento) throws Exception {
		for(ConfiguracionElemento ce : this.configuraciones){
			if (ce.soyParaElemento(tipoElemento))
				return ce;
		}
		throw new Exception("No existe configuracion para el elemento: " + tipoElemento);
	}
	
	private void moverElementos(float deltaTiempo) {
		for(Elemento e : this.elementos)
			e.moverElemento(deltaTiempo, this.dificultad);
	}
	
	private void calcularDanos() {
		float vidaAnterior = 0;
		for(Iterator<Elemento> it = this.elementos.iterator(); it.hasNext();){
			Elemento e = it.next();
			vidaAnterior = this.animal.obtenerVida();
			this.animal.calcularDano(e);
			if (vidaAnterior != this.animal.obtenerVida())
				it.remove();
		}
	}
	
	private void calcularPuntaje() {
		float vida = this.animal.obtenerVida();
		if (vida > this.puntajeAcumulado)
			this.puntajeAcumulado = vida;
	}
}
