package Modelo;

import java.util.*;

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
	
	public Partida(int anchoPantalla, int altoPantalla){
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
		this.random = new Random();
	}
	
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
	
	public void iniciar(float deltaTiempo) throws Exception{
		while(!terminada())
			this.frame(deltaTiempo);
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
		
		this.calcularDanos();
		
		this.calcularPuntaje();
	}
	
	private boolean terminada() {
		return this.animal.estoyMuerto();
	}
	
	private void crearAnimal(int tipoAnimal) {
		Movimiento m = new Lineal(this.anchoPantalla, this.altoPantalla);
		Posicion p = new Posicion(this.anchoPantalla/2, this.altoPantalla-20);
		switch(tipoAnimal)
		{
			case 1: 
				this.animal = new Ave(m, p, this.contexto);
				break;
			case 2:
				this.animal = new Reptil(m, p, this.contexto);
				break;
			case 3:
				this.animal = new Mamifero(m, p, this.contexto);
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
		Posicion p = new Posicion(obtenerRealAlAzar(0,this.anchoPantalla), 0);
		Elemento e;
		switch(tipoElemento)
		{
			case 2:
				e = new Fruta(m,p,puntaje,this.dificultad);
				break;
			case 3:
				e = new Carne(m,p,puntaje,this.dificultad);
				break;
			case 4:
				e = new Asteroide(m,p,puntaje,this.dificultad);
				break;
			case 5:
				e = new Estrella(m,p,puntaje,this.dificultad);
				break;
			case 6:
				e = new Lata(m,p,puntaje,this.dificultad);
				break;
			case 7:
				e = new Ladrillo(m,p,puntaje,this.dificultad);
				break;
			default:
			case 1:
				e = new Verdura(m,p,puntaje,this.dificultad);
				break;
		}
		this.elementos.add(e);
	}
	
	private Movimiento obtenerMovimiento(){
		Movimiento m;
		int i = obtenerEnteroAlAzar(1,3);
		switch(i)
		{
			case 2:
				m = new Diagonal(this.anchoPantalla,this.altoPantalla);
				break;
			case 3:
				m = new Zigzag(this.anchoPantalla,this.altoPantalla);
				break;
			default:
			case 1:
				m = new Recto(this.anchoPantalla,this.altoPantalla);
				break;
		}
		return m;
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
