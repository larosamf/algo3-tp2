package grupo.N6.algochess.modelo.accionesDePartida;

import grupo.N6.algochess.modelo.Coordenada;
import grupo.N6.algochess.modelo.Partida;
import grupo.N6.algochess.modelo.Tablero;

public class Curar implements Accion {

    private Coordenada inicio;
    private Coordenada fin;

    public Curar(Coordenada inicio, Coordenada fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void ejecutarSobre(Partida partida, Tablero tablero) {
        tablero.efectuarCuracion(this.inicio, this.fin);
    }

}