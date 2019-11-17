package grupo.N6.algochess.accionesDePartida;

import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.Partida;
import grupo.N6.algochess.Tablero;

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
