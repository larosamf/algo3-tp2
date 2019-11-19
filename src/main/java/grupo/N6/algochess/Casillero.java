package grupo.N6.algochess;

import grupo.N6.algochess.accionesDeJuego.Ataque;
import grupo.N6.algochess.accionesDeJuego.Cura;
import grupo.N6.algochess.exepciones.CasilleroOcupadoException;
import grupo.N6.algochess.exepciones.CasilleroVacioException;
import grupo.N6.algochess.exepciones.MovimientoInvalidoException;
import grupo.N6.algochess.exepciones.NoSePuedeColocarUnaUnidadEnElSectorEnemigoException;
import grupo.N6.algochess.posicionables.Curable;
import grupo.N6.algochess.posicionables.Atacable;
import grupo.N6.algochess.posicionables.unidades.Unidad;

import java.util.ArrayList;

public class Casillero implements Atacable, Curable {
    private ArrayList<Casillero> adyacencias = new ArrayList<>();

    private Coordenada posicion;
    private Unidad unidad;
    private String bando;

    public Casillero(Coordenada posicion, String bando) {
        this.posicion = posicion;
        this.unidad = null;
        this.bando = bando;
    }



    public Casillero obtenerAdyacenteDerecha(){
        Casillero casilleroBuscado = null;
        for(Casillero casilleroAdyacente: this.adyacencias){
            if( this.posicion.obtenerY() == (casilleroAdyacente.posicion.obtenerY()) &&
                    this.posicion.obtenerX() == (casilleroAdyacente.posicion.obtenerX()-1)){
                casilleroBuscado = casilleroAdyacente;
            }
        }
        return(casilleroBuscado);
    }

    public Casillero obtenerAdyacenteIzquierda(){
        Casillero casilleroBuscado = null;
        for(Casillero casilleroAdyacente: this.adyacencias){
            if( this.posicion.obtenerY() == (casilleroAdyacente.posicion.obtenerY()) &&
                    this.posicion.obtenerX() == (casilleroAdyacente.posicion.obtenerX()+1)){
                casilleroBuscado = casilleroAdyacente;
            }
        }
        return(casilleroBuscado);
    }

    public Casillero obtenerAdyacenteArriba(){
        Casillero casilleroBuscado = null;
        for(Casillero casilleroAdyacente: this.adyacencias){
            if( this.posicion.obtenerY() == (casilleroAdyacente.posicion.obtenerY()+1) &&
                    this.posicion.obtenerX() == (casilleroAdyacente.posicion.obtenerX())){
                casilleroBuscado = casilleroAdyacente;
            }
        }
        return(casilleroBuscado);
    }



    public void ponerUnidad(Unidad unidad, String bandoDelJugador) {
        if (this.unidad != null) {
            throw new CasilleroOcupadoException();
        }
        if (bandoDelJugador != bando) {
    		throw new NoSePuedeColocarUnaUnidadEnElSectorEnemigoException();
    	}
        this.unidad = unidad;
    }
    
    public void moverUnidadA(Casillero casilleroDestino) {
    	Coordenada fin = casilleroDestino.posicion;
    	 if (posicion.equals(fin) || !posicion.esConsecutiva(fin)) {
             throw new MovimientoInvalidoException("El movimiento no es valido");
         }
         for (Casillero casillero1: this.obtenerAdyacencias())
             if (casillero1.estaEnPosicion(fin)) {
                 casillero1.unidad = unidad;
                 this.unidad = null;
             }
    }

    public Unidad obtenerUnidad() {
        if (this.unidad == null) {
            throw new CasilleroVacioException();
        }
        return this.unidad;
    }

    public void sacarUnidad() {
        if (this.unidad == null) {
            throw new CasilleroVacioException();
        }
        this.unidad = null;
    }

    public boolean estaEnPosicion(Coordenada posicion) {
        return this.posicion.equals(posicion);
    }

    public boolean hayUnidad() {
        return !(unidad == null);
    }

    public void asignarAdyacencia(Casillero casillero1) {
        if (!(this.posicion.equals(casillero1.posicion)) & (this.posicion.esConsecutiva(casillero1.posicion)))
            this.adyacencias.add(casillero1);
    }

    public ArrayList<Casillero> obtenerAdyacencias() {
        return this.adyacencias;
    }
    
    private ArrayList<Unidad> buscarUnidadesAliadasADistanciaCortaDelBando(String bandoUnidades) {
    	ArrayList<Unidad> unidades = new ArrayList<>();
    	
    	for (Casillero adyacencia : adyacencias) {
    		if (adyacencia.hayUnidad() && adyacencia.bando == bandoUnidades)
    			unidades.add(adyacencia.unidad);
    		for (Casillero adyacencia2 : adyacencia.adyacencias) {
    			if (adyacencia2.hayUnidad() && adyacencia2.bando == bandoUnidades)
        			unidades.add(adyacencia2.unidad);
    		}
    	}
    	return unidades;
    }
    
    private ArrayList<Unidad> buscarUnidadesEnemigasADistanciaCortaDelBando(String bandoUnidades) {
    	ArrayList<Unidad> unidades = new ArrayList<>();
    	
    	for (Casillero adyacencia : adyacencias) {
    		if (adyacencia.hayUnidad() && adyacencia.bando != bandoUnidades)
    			unidades.add(adyacencia.unidad);
    		for (Casillero adyacencia2 : adyacencia.adyacencias) {
    			if (adyacencia2.hayUnidad() && adyacencia2.bando != bandoUnidades)
        			unidades.add(adyacencia2.unidad);
    		}
    	}
    	return unidades;
    }
    
    private ArrayList<Unidad> buscarBatallon(String bando) {
    	ArrayList<Unidad> soldados = new ArrayList<>();
    	if (!this.obtenerUnidad().esSoldado()) return soldados;
    	
    	for (Casillero adyacencia : adyacencias) {
    		if (adyacencia.hayUnidad() && adyacencia.bando == bando && adyacencia.obtenerUnidad().esSoldado()) {
    			for (Casillero adyacencia2 : adyacencia.adyacencias) {
    	    		if (adyacencia.hayUnidad() && adyacencia.bando == bando && adyacencia.obtenerUnidad().esSoldado())
    	    			soldados.add(adyacencia2.unidad);
    	    			soldados.add(adyacencia.unidad);
    	    			return soldados; /*Batallon son 3 soldados*/
    			}
    		}
    	}
    	return soldados;
    }
    
    public void actualizarEstadoDeUnidad() {
    	ArrayList<Unidad> unidadesAliadas = buscarUnidadesAliadasADistanciaCortaDelBando(this.bando);
    	ArrayList<Unidad> unidadesEnemigas = buscarUnidadesEnemigasADistanciaCortaDelBando(this.bando);
    	ArrayList<Unidad> soldadosContiguos = buscarBatallon(this.bando);
    	
    	unidad.actualizarEstado(unidadesAliadas, unidadesEnemigas, soldadosContiguos);
    	
    }

    @Override
    public void recibirAtaque(Ataque ataque) {

    }

    @Override
    public void recibirCuracion(Cura cura) {

    }
}

