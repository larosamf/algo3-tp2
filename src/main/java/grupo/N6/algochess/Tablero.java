package grupo.N6.algochess.unidades;
package grupo.N6.algochess.exepciones;
package grupo.N6.algochess;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.Coordenada;

import java.util.ArrayList
import java.util.Collection
import java.util.List


public class Tablero {

    private int largoX;
    private int largoY;
    private List<Casillero> casilleros;

    public Tablero(int largoX, int largoY) {
        this.largoX = largoX;
        this.largoY = largoY;
        casilleros = new ArrayList<Casillero>(largoX * largoY);
        for (int i = 1; i <= largoX; ++i) {
            for (int j = 1; j <= largoX; ++j) {
                casilleros.add(new Casillero(new Coordenada(i, j)));
            }
        }
    }

    public Unidad unidadEnCasillero(Coordenada ubicacion) {
        return localizarCasillero(ubicacion).obtenerUnidad();
    }

    public boolean casilleroVacio(Coordenada ubicacion) {
        return localizarCasillero(ubicacion).hayUnidad();
    }

    private Casillero localizarCasillero(Coordenada ubicacion) {
        for (Casillero casillero: casilleros) {
            if (casillero.estaEnPosicion(ubicacion)) {
                return casillero;
            }
        }
        throw new PosicionInvalidaException();
    }

    public void ponerUnidad(Unidad unidad, Coordenada ubicacion) {
        localizarCasillero(ubicacion).ponerUnidad(unidad);
    }


    public void sacarUnidad(Unidad unidad, Coordenada ubicacion) {
        localizarCasillero(ubicacion).sacarUnidad();
    }
    public void efectuarAtaque(Coordenada coordAtacante, Coordenada coordDefensor) {
        Unidad atacante = unidadEnCasillero(coordAtacante);
        Unidad atacado = unidadEnCasillero(coordDefensor);
        atacante.atacar(atacado, coordAtacante.distanciaHasta(coordDefensor));
        if (!atacado.estaVivo())
            localizarCasillero(coordDefensor).sacarUnidad();
    }

    public void inicializarJuego(List<Unidad> unidades1, List<Unidad> unidades2) {
    }
