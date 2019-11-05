package grupo.N6.algochess;

import grupo.N6.algochess.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;


public class Tablero {

    private List<Casillero> casilleros;

    public Tablero(int largoX, int largoY) {
        casilleros = new ArrayList<Casillero>(largoX * largoY);
        for (int i = 1; i <= largoX; ++i)
            for (int j = 1; j <= largoX; ++j)
                casilleros.add(new Casillero(new Coordenada(i, j)));
    }

    public Unidad unidadEnCasillero(Coordenada ubicacion) {
        return localizarCasillero(ubicacion).obtenerUnidad();
    }

    public boolean casilleroVacio(Coordenada ubicacion) {
        return localizarCasillero(ubicacion).hayUnidad();
    }

    private Casillero localizarCasillero(Coordenada ubicacion) {
        for (Casillero casillero : casilleros)
            if (casillero.estaEnPosicion(ubicacion)) return casillero;
    }

    public void ponerUnidad(Unidad unidad, Coordenada ubicacion) {
        localizarCasillero(ubicacion).ponerUnidad(unidad);
    }

    public void sacarUnidad(Unidad unidad, Coordenada ubicacion) {
        localizarCasillero(ubicacion).sacarUnidad();
    }


    public void efectuarAtaque(Coordenada inicio, Coordenada fin) {
        Unidad atacante = unidadEnCasillero(inicio);
        Unidad atacado = unidadEnCasillero(fin);
        atacante.atacar(atacado, inicio.distanciaHasta(fin));
    }

    public void inicializarJuego(List<Unidad> unidades1, List<Unidad> unidades2) {
    }

    public void efectuarCuracion(Coordenada inicio, Coordenada fin) {
        Unidad curador = unidadEnCasillero(inicio);
        Unidad curado = unidadEnCasillero(fin);
        curador.curar(curado, inicio.distanciaHasta(fin));
    }

    public void efectualMovimiento(Coordenada inicio, Coordenada fin) {
        Unidad movible = unidadEnCasillero(inicio);
        movible.mover(curado, inicio.distanciaHasta(fin));
    }
}
