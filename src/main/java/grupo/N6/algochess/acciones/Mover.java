package grupo.N6.algochess.acciones;

import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.Partida;
import grupo.N6.algochess.Tablero;
import grupo.N6.algochess.exepciones.MovimientoInvalidoException;
import grupo.N6.algochess.unidades.Unidad;

public class Mover implements Accion {

    private Coordenada inicio;
    private Coordenada fin;

    public Mover(Coordenada inicio, Coordenada fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void ejecutarSobre(Partida partida, Tablero tablero) {
        if (inicio.equals(fin) || inicio.esConsecutiva(fin)) {
            throw new MovimientoInvalidoException("El movimiento no es valido");
        }
        Unidad unidad;
        unidad = tablero.unidadEnCasillero(inicio);
        tablero.ponerUnidad(unidad, fin);
        tablero.sacarUnidad(unidad, inicio);
    }
}

