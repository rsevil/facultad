package Modelo;

import java.util.*;

import Modelo.Fabricas.*;

public class Partida extends Observable {
	private String nombre;
	private Dificultad dificultad;
	private float puntajeAcumulado;
	private int frames;
	private int anchoPantalla;
	private int altoPantalla;
	private Random random;
	private boolean derecha;
	private boolean izquierda;
	
	private Animal animal;
	private Contexto contexto;
	private Map<Integer,Float> puntajesElementos;
	private Collection<Elemento> elementos;
	
	private Map<Integer,FabricaAnimal> fabricasAnimales;
	private Map<Integer,FabricaElemento> fabricasElementos;
	private Map<Integer,FabricaContexto> fabricasContextos;
	private Map<Integer,FabricaMovimiento> fabricasMovimientos;
	
	private int claveMovimientoLineal = 4;
	private float puntajeElementoDefault = 1f;
	private float velocidadElementoDefault = 1f;
	private int cantidadMaximaElementos = 10;
	private int framesPorElemento = 180;
	
	public Partida(
			int anchoPantalla, 
			int altoPantalla, 
			Map<Integer,FabricaAnimal> fabricasAnimales,
			Map<Integer,FabricaElemento> fabricasElementos,
			Map<Integer,FabricaContexto> fabricasContextos, 
			Map<Integer,FabricaMovimiento> fabricasMovimientos)
	{
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
		this.fabricasAnimales = fabricasAnimales;
		this.fabricasElementos = fabricasElementos;
		this.fabricasContextos = fabricasContextos;
		this.fabricasMovimientos = fabricasMovimientos;
		
		this.random = new Random();
		this.puntajesElementos = new HashMap<Integer,Float>();
		this.elementos = new ArrayList<Elemento>();
	}
	
	public void elegirNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void elegirAnimal(int tipoAnimal) throws Exception {
		this.crearAnimal(tipoAnimal);
	}
	
	public void elegirContexto(int tipoContexto) throws Exception {
		this.crearContexto(tipoContexto);
	}
	
	public void elegirDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	public void configurarElemento(int tipoElemento, float puntaje) {
		this.puntajesElementos.put(tipoElemento, puntaje);
	}
	
	public void iniciar() throws Exception{
		long ti = System.nanoTime();
		while(!terminada()){
			long tf = System.nanoTime();
			float deltaTiempo = (tf - ti) / 1000000000f;
			ti = tf;
			this.frame(deltaTiempo);
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	public Puntaje obtenerPuntaje() {
		return new Puntaje(this.nombre, this.puntajeAcumulado);
	}
	
	public void asignarDerecha(boolean derecha){
		this.derecha = derecha;
	}
	
	public void asignarIzquierda(boolean izquierda){
		this.izquierda = izquierda;
	}
	
	private void frame(float deltaTiempo) throws Exception {
		this.frames++;
		
		if (this.frames % this.framesPorElemento == 0 && this.elementos.size() <= this.cantidadMaximaElementos){
			this.frames = 0;
			this.crearElemento(this.obtenerEnteroAlAzar(1,7));
		}
		
		this.animal.moverAnimal(deltaTiempo, this.derecha, this.izquierda);
		
		this.moverElementos(deltaTiempo);
		
		this.calcularVida();
		
		this.calcularPuntaje();
		
		this.eliminarElementos();
	}
	
	private boolean terminada() {
		return this.animal.estoyMuerto();
	}
	
	private void crearAnimal(int tipoAnimal) {
		Posicion p = new Posicion(this.anchoPantalla/2, this.altoPantalla-20);
		Movimiento m =  this.fabricasMovimientos.get(claveMovimientoLineal).Crear(anchoPantalla, altoPantalla);		
		this.animal = this.fabricasAnimales.get(tipoAnimal).Crear(m, p, this.contexto);
	}
	
	private void crearContexto(int tipoContexto) {
		this.contexto = this.fabricasContextos.get(tipoContexto).Crear();
	}
	
	private void crearElemento(int tipoElemento) throws Exception {
		Movimiento movimiento = this.obtenerMovimiento();
		Posicion posicion = new Posicion(obtenerRealAlAzar(0,this.anchoPantalla), 0);
		
		float velocidad = this.velocidadElementoDefault;
		switch(dificultad){
			case dificil:
				velocidad = velocidad * 2;
				break;
			case facil:
				velocidad = velocidad / 2;
				break;
			default:
				break;
		}
		
		float puntaje = this.puntajesElementos.getOrDefault(tipoElemento, this.puntajeElementoDefault);
		
		this.elementos.add(
				this.fabricasElementos.get(tipoElemento)
					.Crear(movimiento, posicion, velocidad, velocidad, puntaje));
	}
	
	private Movimiento obtenerMovimiento() throws Exception{
		return this.fabricasMovimientos.get(obtenerEnteroAlAzar(1,3)).Crear(this.anchoPantalla,this.altoPantalla);
	}
	
	private int obtenerEnteroAlAzar(int min, int max){
	    return (int)obtenerRealAlAzar(min,max);
	}
	
	private float obtenerRealAlAzar(float min, float max){
		float rango = max - min + 1;
	    float fraccion = rango * this.random.nextFloat();
	    return fraccion + min; 
	}
	
	private void moverElementos(float deltaTiempo) {
		for(Elemento e : this.elementos)
			e.moverElemento(deltaTiempo);
	}
	
	private void calcularVida() {
		float vidaAnterior = 0;
		for(Iterator<Elemento> it = this.elementos.iterator(); it.hasNext();){
			Elemento e = it.next();
			vidaAnterior = this.animal.obtenerVida();
			this.animal.calcularPuntaje(e);
			if (vidaAnterior != this.animal.obtenerVida())
				it.remove();
		}
	}
	
	private void calcularPuntaje() {
		float vida = this.animal.obtenerVida();
		if (vida > this.puntajeAcumulado)
			this.puntajeAcumulado = vida;
	}
	
	private void eliminarElementos(){
		for(Iterator<Elemento> it = this.elementos.iterator(); it.hasNext();){
			Elemento e = it.next();
			if (!e.ocupaCoordenadas(0, anchoPantalla, 0, altoPantalla))
				it.remove();
		}
	}
}
