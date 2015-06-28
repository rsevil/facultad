package Modelo;

import java.util.*;

import javax.swing.JFrame;

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
	private Map<Integer, Float> puntajesElementos;
	private Collection<Elemento> elementos;

	private Map<Integer, FabricaAnimal> fabricasAnimales;
	private Map<Integer, FabricaElemento> fabricasElementos;
	private Map<Integer, FabricaContexto> fabricasContextos;
	private Map<Integer, FabricaMovimiento> fabricasMovimientos;

	public Partida(int anchoPantalla, int altoPantalla,
			Map<Integer, FabricaAnimal> fabricasAnimales,
			Map<Integer, FabricaElemento> fabricasElementos,
			Map<Integer, FabricaContexto> fabricasContextos,
			Map<Integer, FabricaMovimiento> fabricasMovimientos) {
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
		this.fabricasAnimales = fabricasAnimales;
		this.fabricasElementos = fabricasElementos;
		this.fabricasContextos = fabricasContextos;
		this.fabricasMovimientos = fabricasMovimientos;

		this.random = new Random();
		this.puntajesElementos = new HashMap<Integer, Float>();
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

	public void iniciar() throws Exception {
		float fps = 1000 / Constantes.FRAMES_POR_SEGUNDO;
		long ti = System.nanoTime();
		while (!terminada()) {
			long tf = System.nanoTime();
			float deltaTiempo = (tf - ti) / 1000000000f;
			ti = tf;
			this.frame(deltaTiempo);
			this.setChanged();
			this.notifyObservers();
			Thread.sleep((long)fps);
		}
		if(terminada())
			System.exit(0);
	}

	public Puntaje obtenerPuntaje() {
		return new Puntaje(this.nombre, this.puntajeAcumulado);
	}

	public void asignarDerecha(boolean derecha) {
		this.derecha = derecha;
	}

	public void asignarIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}

	public Animal obtenerAnimal() {
		return this.animal;
	}

	public Contexto obtenerContexto() {
		return this.contexto;
	}

	public Collection<Elemento> obtenerElementos() {
		return this.elementos;
	}

	private void frame(float deltaTiempo) throws Exception {
		this.frames++;

		if (this.frames % (Constantes.FRAMES_POR_ELEMENTO / this.dificultad.obtenerValor() ) == 0
				&& this.elementos.size() <= Constantes.CANTIDAD_MAXIMA_ELEMENTOS) {
			this.frames = 0;
			this.crearElemento(this.obtenerEnteroAlAzar(1, 7));
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
		Posicion p = new Posicion(this.anchoPantalla / 2, this.altoPantalla - Constantes.TAMANO_LADO_ANIMAL);
		Movimiento m = this.fabricasMovimientos.get(Constantes.CLAVE_MOVIMIENTO_LINEAL).Crear(anchoPantalla, altoPantalla);
		this.animal = this.fabricasAnimales.get(tipoAnimal).Crear(m, p, this.contexto, Constantes.VIDA_INICIAL_ANIMAL);
	}

	private void crearContexto(int tipoContexto) {
		this.contexto = this.fabricasContextos.get(tipoContexto).Crear();
	}

	private void crearElemento(int tipoElemento) throws Exception {
		Movimiento movimiento = this.obtenerMovimiento();
		Posicion posicion = new Posicion(obtenerRealAlAzar(0, this.anchoPantalla), 0);

		float vx = Constantes.VELOCIDAD_X_ELEMENTO_DEFAULT;
		float vy = Constantes.VELOCIDAD_Y_ELEMENTO_DEFAULT;
		switch (dificultad) {
		case dificil:
			vx = vx * Constantes.MULTIPLICADOR_VELOCIDAD_ELEMENTO_DIFICIL;
			vy = vy * Constantes.MULTIPLICADOR_VELOCIDAD_ELEMENTO_DIFICIL;
			break;
		case medio:
			vx = vx * Constantes.MULTIPLICADOR_VELOCIDAD_ELEMENTO_MEDIO;
			vy = vy * Constantes.MULTIPLICADOR_VELOCIDAD_ELEMENTO_MEDIO;
			break;
		case facil:
			vx = vx * Constantes.MULTIPLICADOR_VELOCIDAD_ELEMENTO_FACIL;
			vy = vy * Constantes.MULTIPLICADOR_VELOCIDAD_ELEMENTO_FACIL;
			break;
		}

		float puntaje = this.puntajesElementos.getOrDefault(tipoElemento,Constantes.PUNTAJE_ELEMENTO_DEFAULT);
		this.elementos.add(this.fabricasElementos.get(tipoElemento).Crear(movimiento, posicion, vx, vy, puntaje));
	}

	private Movimiento obtenerMovimiento() throws Exception {
		return this.fabricasMovimientos.get(obtenerEnteroAlAzar(1, 3)).Crear(this.anchoPantalla, this.altoPantalla);
	}

	private int obtenerEnteroAlAzar(int min, int max) {
		return (int) obtenerRealAlAzar(min, max);
	}

	private float obtenerRealAlAzar(float min, float max) {
		float rango = max - min + 1;
		float fraccion = rango * this.random.nextFloat();
		return fraccion + min;
	}

	private void moverElementos(float deltaTiempo) {
		for (Elemento e : this.elementos)
			e.moverElemento(deltaTiempo);
	}

	private void calcularVida() {
		float vidaAnterior = 0;
		for (Iterator<Elemento> it = this.elementos.iterator(); it.hasNext();) {
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

	private void eliminarElementos() {
		for (Iterator<Elemento> it = this.elementos.iterator(); it.hasNext();) {
			Elemento e = it.next();
			if (!e.ocupaCoordenadas(0, anchoPantalla, 0, altoPantalla))
				it.remove();
		}
	}
}
