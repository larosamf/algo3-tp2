package grupo.N6.algochess;

import grupo.N6.algochess.exepciones.CasilleroOcupadoException;
import grupo.N6.algochess.exepciones.CasilleroVacioException;
import grupo.N6.algochess.unidades.Unidad;

import java.util.ArrayList;

public class Casillero {
    private ArrayList<Casillero> adyacencias = new ArrayList<>();
    private Coordenada posicion;
    private Unidad unidad;

    public Casillero(Coordenada posicion) {
        this.posicion = posicion;
        this.unidad = null;
    }

    public void ponerUnidad(Unidad unidad) {
        if (this.unidad != null) {
            throw new CasilleroOcupadoException();
        }
        this.unidad = unidad;
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
}

