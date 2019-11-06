package grupo.N6.algochess;

import grupo.N6.algochess.exepciones.PosicionInvalidaExeption;
import grupo.N6.algochess.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;


public class Tablero {

    private ArrayList<Casillero> casilleros;

    public Tablero(int largoX, int largoY) {
        casilleros = new ArrayList<Casillero>(largoX * largoY);
        for (int i = 1; i <= largoX; ++i)
            for (int j = 1; j <= largoX; ++j)
                casilleros.add(new Casillero(new Coordenada(i, j)));
        asignarAdyacencias();
    }

    private void asignarAdyacencias() {
        for (Casillero casillero : casilleros)
            for (Casillero casillero1 : casilleros)
                casillero.asignarAdyacencia(casillero1);
    }

    private Casillero localizarCasillero(Coordenada ubicacion) {
        for (Casillero casillero : casilleros)
            if (casillero.estaEnPosicion(ubicacion))
                return casillero;
        throw new PosicionInvalidaExeption("La coordenada es invalida.");
    }

    private Unidad unidadEnCasillero(Coordenada ubicacion) {
        return localizarCasillero(ubicacion).obtenerUnidad();
    }

    /* INICIO DE JUEGO */

    public void inicializarJuego(List<Unidad> unidades1, List<Unidad> unidades2) {
    }

    /* ACCIONES */

    public void efectuarMovimiento(Coordenada inicio, Coordenada fin) {
        Unidad unidad = this.unidadEnCasillero(inicio);
        unidad.mover(localizarCasillero(inicio),inicio, fin);
    }

    public void efectuarAtaque(Coordenada inicio, Coordenada fin) {
        Unidad atacante = unidadEnCasillero(inicio);
        Unidad atacado = unidadEnCasillero(fin);
        atacante.atacar(atacado, inicio.distanciaHasta(fin));
    }

    public void efectuarCuracion(Coordenada inicio, Coordenada fin) {
        Unidad curador = unidadEnCasillero(inicio);
        Unidad curado = unidadEnCasillero(fin);
        curador.curar(curado, inicio.distanciaHasta(fin));
    }

}
