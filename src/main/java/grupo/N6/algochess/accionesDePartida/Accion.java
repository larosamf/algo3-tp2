package grupo.N6.algochess.accionesDePartida;

import grupo.N6.algochess.Partida;
import grupo.N6.algochess.Tablero;

public interface Accion {

    void ejecutarSobre(Partida partida, Tablero tablero);
}