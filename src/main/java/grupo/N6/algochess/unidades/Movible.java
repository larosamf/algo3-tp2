package grupo.N6.algochess.unidades;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.exepciones.MovimientoInvalidoException;

public interface Movible {

    public void mover(Casillero casillero, Coordenada inicio, Coordenada fin);
}
