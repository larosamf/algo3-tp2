package grupo.N6.algochess.modelo.accionesDePartida;

import grupo.N6.algochess.modelo.Coordenada;
import grupo.N6.algochess.modelo.Partida;
import grupo.N6.algochess.modelo.Tablero;

public class Atacar implements Accion {

    private Coordenada inicio;
    private Coordenada fin;

    public Atacar(Coordenada inicio, Coordenada fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void ejecutarSobre(Partida partida, Tablero tablero) {
        tablero.efectuarAtaque(this.inicio, this.fin);
    }

}
