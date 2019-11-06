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
        tablero.efectuarMovimiento(this.inicio,this.fin);
    }
}

