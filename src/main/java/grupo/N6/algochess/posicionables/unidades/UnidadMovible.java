package grupo.N6.algochess.posicionables.unidades;

import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.exepciones.MovimientoInvalidoException;
import grupo.N6.algochess.Casillero;

public abstract class UnidadMovible extends Unidad {

    @Override
    public void mover(Casillero casillero, Coordenada inicio, Coordenada fin) {
        if (inicio.equals(fin) || !inicio.esConsecutiva(fin)) {
            throw new MovimientoInvalidoException("El movimiento no es valido");
        }
        for (Casillero casillero1: casillero.obtenerAdyacencias())
            if (casillero1.estaEnPosicion(fin)) {
                casillero1.ponerUnidad(this);
            }

    }
}

