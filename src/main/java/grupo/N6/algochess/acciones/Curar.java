package grupo.N6.algochess.acciones;

import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.Partida;
import grupo.N6.algochess.Tablero;

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