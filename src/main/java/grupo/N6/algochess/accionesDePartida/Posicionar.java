package grupo.N6.algochess.accionesDePartida;

import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.Partida;
import grupo.N6.algochess.Tablero;

public class Posicionar implements Accion {

    private Coordenada posicion;

    public Posicionar(Coordenada posicion) {
        this.posicion = posicion;
    }

    @Override
    public void ejecutarSobre(Partida partida, Tablero tablero) {

    }

}

