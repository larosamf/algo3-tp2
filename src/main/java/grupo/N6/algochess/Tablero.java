package grupo.N6.algochess;

import grupo.N6.algochess.exepciones.PosicionInvalidaExeption;
import grupo.N6.algochess.posicionables.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

import grupo.N6.algochess.exepciones.PosicionInvalidaExeption;
import grupo.N6.algochess.posicionables.unidades.Unidad;


public class Tablero {

    private ArrayList<Casillero> casilleros;
    private String bandoAliado; /*cambia turno a turno*/
    private String bandoEnemigo;

    public Tablero(int largoX, int largoY) {
    	
        casilleros = new ArrayList<Casillero>(largoX * largoY);
        
        for (int i = 1; i <= largoX; i++) {
            for (int j = 1; j <= largoX; j++) {
                String bando = "Bando1";
                if (j > largoY / 2) {
                    bando = "Bando2";
                }
                casilleros.add(new Casillero(new Coordenada(i, j), bando));
            }
        }
        this.asignarAdyacencias();
        
        bandoAliado = "Bando1";
        bandoEnemigo = "Bando2";
    }

    public void cambiarTurno() {
    	String aux = bandoAliado;
    	bandoAliado = bandoEnemigo;
    	bandoEnemigo = aux;
    }

    private void asignarAdyacencias() {
        for (Casillero casillero : casilleros)
            for (Casillero casillero1 : casilleros)
                casillero.asignarAdyacencia(casillero1);
    }

    public Casillero obtenerCasilleroDeArribaDe(Coordenada coordenadaActual){
        return(this.localizarCasillero(coordenadaActual).obtenerAdyacenteArriba());
    }

    public Casillero obtenerCasilleroDeDerechaDe(Coordenada coordenadaActual){
        return(this.localizarCasillero(coordenadaActual).obtenerAdyacenteDerecha());
    }

    public Casillero obtenerCasilleroDeIzquierdaDe(Coordenada coordenadaActual){
        return(this.localizarCasillero(coordenadaActual).obtenerAdyacenteIzquierda());
    }

    public Casillero obtenerCasilleroDeAbajoDe(Coordenada coordenadaActual){
        return(this.localizarCasillero(coordenadaActual).obtenerAdyacenteAbajo());
    }

    public Casillero obtenerCasilleroDeArribaALaDerechaDe(Coordenada coordenadaActual){
        return(this.localizarCasillero(coordenadaActual).obtenerAdyacenteDerecha().obtenerAdyacenteArriba());
    }

    public Casillero localizarCasillero(Coordenada ubicacion) {
        for (Casillero casillero : casilleros)
            if (casillero.estaEnPosicion(ubicacion))
                return casillero;
        throw new PosicionInvalidaExeption("La coordenada es invalida.");
    }

    public void ponerUnidad(Unidad unidad, Coordenada ubicacion) {
        localizarCasillero(ubicacion).ponerUnidad(unidad, bandoAliado);
    }
    
    public int cantidadCasilleros(){
        return casilleros.size();
    }
    
    public Unidad unidadEnCasillero(Coordenada ubicacion) {
        return localizarCasillero(ubicacion).obtenerUnidad();
    }
    
    public void actualizarEstadoDeUnidades() {
    	for (Casillero casillero : casilleros) {
    		casillero.actualizarEstadoDeUnidad();
    	}
    }

    /* INICIO DE JUEGO */

    public void inicializarJuego(List<Unidad> unidades1, List<Unidad> unidades2) {
    }

    /* ACCIONES */

    public void efectuarMovimiento(Coordenada inicio, Coordenada fin) {
    	Unidad unidadAMover = localizarCasillero(inicio).obtenerUnidad();
    	unidadAMover.mover(localizarCasillero(inicio), localizarCasillero(fin));
    }

    public void efectuarAtaque(Coordenada inicio, Coordenada fin) {
        Unidad atacante = unidadEnCasillero(inicio);
        Unidad atacado = unidadEnCasillero(fin);
        boolean atacadoEstaEnTerritorioEnemigo = this.localizarCasillero(fin).estaEnTerritorioEnemigo(bandoAliado);
        atacante.atacar(atacado, inicio.distanciaHasta(fin), localizarCasillero(fin));
        if (atacadoEstaEnTerritorioEnemigo) {
        	atacado.recibirMasAtaque(atacante.getDaño()*0.05);
        }
    }

    public void efectuarCuracion(Coordenada inicio, Coordenada fin) {
        Unidad curador = unidadEnCasillero(inicio);
        Unidad curado = unidadEnCasillero(fin);
        curador.curar(curado, inicio.distanciaHasta(fin));
    }

}
