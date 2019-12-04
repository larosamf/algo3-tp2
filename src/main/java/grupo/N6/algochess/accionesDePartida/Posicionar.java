package grupo.N6.algochess.accionesDePartida;

import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.Partida;
import grupo.N6.algochess.Tablero;
import grupo.N6.algochess.exepciones.EquipoIncorrectoException;
import grupo.N6.algochess.posicionables.unidades.Unidad;

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

