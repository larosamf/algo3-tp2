package grupo.N6.algochess.modelo.accionesDePartida;

import grupo.N6.algochess.modelo.Coordenada;
import grupo.N6.algochess.modelo.Partida;
import grupo.N6.algochess.modelo.Tablero;
import grupo.N6.algochess.modelo.exepciones.EquipoIncorrectoException;
import grupo.N6.algochess.modelo.posicionables.unidades.Unidad;

public class Posicionar implements Accion {

    private Coordenada posicion;
    private Unidad unidad;

    public Posicionar(Unidad unidad, Coordenada posicion) {
        this.posicion = posicion;
    }

    @Override
    public void ejecutarSobre(Partida partida, Tablero tablero) {
        if (!partida.puedeJugar(unidad)){
            throw new EquipoIncorrectoException();
        }
        tablero.efectuarPosicionamiento(this.unidad, this.posicion);
    }
}

