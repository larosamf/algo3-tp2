package grupo.N6.algochess.modelo.accionesDePartida;

import grupo.N6.algochess.modelo.Partida;
import grupo.N6.algochess.modelo.Tablero;

public interface Accion {

    void ejecutarSobre(Partida partida, Tablero tablero);
}