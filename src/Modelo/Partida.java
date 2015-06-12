package Modelo;

import java.util.*;

import Modelo.Fabricas.*;

public class Partida {
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
	private Collection<ConfiguracionElemento> configuraciones;
	private Collection<Elemento> elementos;
	
	private Collection<Map.Entry<Integer,FabricaAnimal>> fabricasAnimales;
	private Collection<Map.Entry<Integer,FabricaElemento>> fabricasElementos;
	private Collection<Map.Entry<Integer,FabricaContexto>> fabricasContextos;
	private Collection<Map.Entry<Integer, FabricaMovimiento>> fabricasMovimientos;
	
	public Partida(
			int anchoPantalla, 
			int altoPantalla, 
			Collection<Map.Entry<Integer,FabricaAnimal>> fabricasAnimales,
			Collection<Map.Entry<Integer,FabricaElemento>> fabricasElementos,
			Collection<Map.Entry<Integer,FabricaContexto>> fabricasContextos, 
			Collection<Map.Entry<Integer, FabricaMovimiento>> fabricasMovimientos)
	{
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
		this.fabricasAnimales = fabricasAnimales;
		this.fabricasElementos = fabricasElementos;
		this.fabricasContextos = fabricasContextos;
		this.fabricasMovimientos = fabricasMovimientos;
		
		this.random = new Random();
		this.configuraciones = new ArrayList<ConfiguracionElemento>();
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
	
	public void iniciar() throws Exception{
		long ti = System.nanoTime();
		while(!terminada()){
			long tf = System.nanoTime();
			float deltaTiempo = (tf - ti) / 1000000000f;
			ti = tf;
			this.frame(deltaTiempo);
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
		
		if (this.frames % 180 == 0 && this.elementos.size() < 10){
			this.frames = 0;
			this.crearElemento(this.obtenerEnteroAlAzar(1,7));
		}
		
		this.animal.moverAnimal(deltaTiempo, this.derecha, this.izquierda);
		
		this.moverElementos(deltaTiempo);
		
		this.calcularVida();
		
		this.calcularPuntaje();
	}
	
	private boolean terminada() {
		return this.animal.estoyMuerto();
	}
	
	private void crearAnimal(int tipoAnimal) throws Exception {
		Movimiento m = new Lineal(this.anchoPantalla, this.altoPantalla);
		Posicion p = new Posicion(this.anchoPantalla/2, this.altoPantalla-20);
		
		FabricaAnimal fabrica = null;
		for(Map.Entry<Integer,FabricaAnimal> kv : this.fabricasAnimales){
			if (kv.getKey() == tipoAnimal){
				fabrica = kv.getValue();
				break;
			}
		}
		
		if(fabrica == null)
			throw new Exception("Fabrica de animal no existe, tipoAnimal: " + tipoAnimal);
		
		this.animal = fabrica.Crear(m, p, this.contexto);
	}
	
	private void crearContexto(int tipoContexto) throws Exception {
		FabricaContexto fabrica = null;
		for(Map.Entry<Integer,FabricaContexto> kv : this.fabricasContextos){
			if (kv.getKey() == tipoContexto){
				fabrica = kv.getValue();
				break;
			}
		}
		
		if(fabrica == null)
			throw new Exception("Fabrica de contexto no existe, tipoContexto: " + tipoContexto);
		
		this.contexto = fabrica.Crear();
	}
	
	private void crearElemento(int tipoElemento) throws Exception {
		float puntaje = 1;
		if (this.existeConfiguracionElemento(tipoElemento)){
			ConfiguracionElemento ce = this.obtenerConfiguracionElemento(tipoElemento);
			puntaje = ce.obtenerPuntaje();
		}
		
		Movimiento m = this.obtenerMovimiento();
		Posicion p = new Posicion(obtenerRealAlAzar(0,this.anchoPantalla), 0);
		
		FabricaElemento fabrica = null;
		for(Map.Entry<Integer,FabricaElemento> kv : this.fabricasElementos){
			if (kv.getKey() == tipoElemento){
				fabrica = kv.getValue();
				break;
			}
		}
		
		if(fabrica == null)
			throw new Exception("Fabrica de elemento no existe, tipoElemento: " + tipoElemento);
		
		float v = 1;
		switch(dificultad){
			case dificil:
				v = v * 2;
				break;
			case facil:
				v = v / 2;
				break;
			default:
				break;
		}
		
		this.elementos.add(fabrica.Crear(m, p, v, v, puntaje));
	}
	
	private Movimiento obtenerMovimiento() throws Exception{
		int tipoMovimiento = obtenerEnteroAlAzar(1,3);
		
		FabricaMovimiento fabrica = null;
		for(Map.Entry<Integer,FabricaMovimiento> kv : this.fabricasMovimientos){
			if (kv.getKey() == tipoMovimiento){
				fabrica = kv.getValue();
				break;
			}
		}
		
		if(fabrica == null)
			throw new Exception("Fabrica de movimiento no existe, tipoMovimiento: " + tipoMovimiento);
		
		return fabrica.Crear(this.anchoPantalla,this.altoPantalla);
	}
	
	private int obtenerEnteroAlAzar(int min, int max){
	    return (int)obtenerRealAlAzar(min,max);
	}
	
	private float obtenerRealAlAzar(float min, float max){
		float rango = max - min + 1;
	    float fraccion = rango * this.random.nextFloat();
	    return fraccion + min; 
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
}
