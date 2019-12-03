package grupo.N6.algochess;

import grupo.N6.algochess.accionesDeJuego.AtaqueExpansivo;
import grupo.N6.algochess.accionesDePartida.Atacar;
import grupo.N6.algochess.accionesDePartida.Curar;
import grupo.N6.algochess.accionesDePartida.Mover;
import grupo.N6.algochess.accionesDePartida.MoverBatallon;
import grupo.N6.algochess.accionesDePartida.Posicionar;
import grupo.N6.algochess.exepciones.CasilleroVacioException;
import grupo.N6.algochess.posicionables.Atacable;
import grupo.N6.algochess.posicionables.unidades.Batallon;
import grupo.N6.algochess.posicionables.unidades.Catapulta;
import grupo.N6.algochess.posicionables.unidades.Curandero;
import grupo.N6.algochess.posicionables.unidades.Jinete;
import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;
import grupo.N6.algochess.posicionables.unidades.Unidad;

public class Algochess {

	private static final int TAMAÑO_TABLERO = 20;
	Jugador jugador1;
	Jugador jugador2;
	Partida partida;
	
    public Algochess() {
    	jugador1 = new Jugador();
    	jugador2 = new Jugador();
    	partida = new Partida(jugador1, jugador2);
    }
    
    public int tamañoDeTablero() {
    	return TAMAÑO_TABLERO;
    }
    
    public void ingresarNombreDeJugador(String nombre) {
    	/*Se guarda el nombre del jugador*/
    	partida.obtenerJugadorActivo().setNombre(nombre);
    }
    
    public void atacar(int desdeX, int desdeY, int hastaX, int hastaY) {
    	Unidad atacante = partida.obtenerCasillero(desdeX, desdeY).obtenerUnidad();
    	
    	/*Ataque de catapulta*/
    	if (atacante.esCatapulta()) {
    		Casillero casillero = partida.obtenerCasillero(hastaX, hastaY);
    		AtaqueExpansivo ataque = new AtaqueExpansivo(atacante.getDaño());
    		ataque.efectuarSobre(casillero);
    		return;
    	}
    	
    	/*Ataque del resto de las unidades*/
    	Coordenada desde = new Coordenada(desdeX, desdeY);
    	Coordenada hasta = new Coordenada(hastaX, hastaY);
    	Atacar atacar = new Atacar(desde, hasta);
    	partida.jugar(atacar);
    }
    
    public void mover(int desdeX, int desdeY, int hastaX, int hastaY) {
    	Coordenada desde = new Coordenada(desdeX, desdeY);
    	Coordenada hasta = new Coordenada(hastaX, hastaY);
    	Mover mover = new Mover(desde, hasta);
    	partida.jugar(mover);
    }
    
    public void moverBatallon(int desdeX, int desdeY, int hastaX, int hastaY) {
    	Casillero desde = partida.obtenerCasillero(desdeX, desdeY);
    	Casillero hasta = partida.obtenerCasillero(hastaX, hastaY);
    	Batallon batallon = partida.obtenerBatallon(desdeX, desdeY);
    	MoverBatallon mover = new MoverBatallon(batallon, desde, hasta);
    	partida.jugar(mover);
    }
    
    public void curar(int desdeX, int desdeY, int hastaX, int hastaY) {
    	Coordenada desde = new Coordenada(desdeX, desdeY);
    	Coordenada hasta = new Coordenada(hastaX, hastaY);
    	Curar curar = new Curar(desde, hasta);
    	partida.jugar(curar);
    }
    
    public void colocarUnidad(String nombreUnidad, int x, int y) {
    	/*Nombre de unidad puede ser jinete, soldado, catapulta o curandero*/
    	
    	Coordenada ubicacion = new Coordenada(x, y);
    	Unidad unidad;
    	if (nombreUnidad == "jinete") 
    		unidad = new Jinete();
    	else if (nombreUnidad == "soldado")
    		unidad = new SoldadoDeInfanteria();
    	else if (nombreUnidad == "catapulta")
    		unidad = new Catapulta();
    	else 
    		unidad = new Curandero();
    	
    	Posicionar posicionar = new Posicionar(unidad, ubicacion);
    	partida.jugar(posicionar);
    }
    
    public String terminarTurno() {
    	/*Si se obtuvo un ganador se develve el nombre del ganador.
    	 Sino se devuelve null.*/
    	partida.terminarTurno();
    	if (partida.hayGanador())
    		partida.obtenerGanador().nombre();
    	return null;
    }

    public String tipoUnidadEnCasillero(int x, int y) {
    	/*Devuelve la unidad del casillero. En caso de estar vacío devuelve null*/
    	Coordenada ubicacion = new Coordenada(x,y);
    	Unidad unidad;
    	try {
    		unidad = partida.obtenerUnidadDePosicion(ubicacion);
    	} catch (CasilleroVacioException e) {
    		return null;
    	}
    	if (unidad.esCatapulta())
    		return "catapulta";
    	if (unidad.esCurandero())
    		return "curandero";
    	if (unidad.esJinete())
    		return "jinete";
    	return "solado";
    }
    
    public int vidaDeUnidadEnCasillero(int x, int y) {
    	/*En caso de estar vacío o que la unidad no esté más viva devuelve 0*/
    	Coordenada ubicacion = new Coordenada(x,y);
    	Unidad unidad;
    	try {
    		unidad = partida.obtenerUnidadDePosicion(ubicacion);
    	} catch (CasilleroVacioException e) {
    		return 0;
    	}
    	return unidad.getVida();
    }
    
    public int dañoDeUnidadEnCasillero(int x, int y) {
    	/*En caso de estar vacío o que la unidad no esté más viva devuelve 0*/
    	Coordenada ubicacion = new Coordenada(x,y);
    	Unidad unidad;
    	try {
    		unidad = partida.obtenerUnidadDePosicion(ubicacion);
    	} catch (CasilleroVacioException e) {
    		return 0;
    	}
    	return unidad.getDaño();
    }
    
    public int costoDeUnidadEnCasillero(int x, int y) {
    	/*En caso de estar vacío o que la unidad no esté más viva devuelve 0*/
    	Coordenada ubicacion = new Coordenada(x,y);
    	Unidad unidad;
    	try {
    		unidad = partida.obtenerUnidadDePosicion(ubicacion);
    	} catch (CasilleroVacioException e) {
    		return 0;
    	}
    	return unidad.getCosto();
    }
    
    public String nombreJugadorActivo() {
    	/*Devuelve el nombre del jugador del cual es el turno para jugar*/
    	return partida.obtenerJugadorActivo().nombre();
    }
    
}