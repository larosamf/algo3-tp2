package grupo.N6.algochess.unidades;

import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.exepciones.JugadaInvalidaExepcion;

/**
 * 
 *
 */
public class SoldadoDeInfanteria extends UnidadMovible implements Atacable, Curable {

	public SoldadoDeInfanteria() {
		vida = 100;
		costo = 1;
		daño = 10;
		distanciaAccion = 1;

	}

	@Override
	public void atacar(Unidad atacado, int distancia) {
		if(distancia>distanciaAccion) {
            throw new DistanciaInvalidaExepcion("maximo de 1");
        }
        atacado.recibirDaño(daño);
	}

    @Override
    public void terminarTurno() {

    }

    @Override
    public void curar(Unidad curado, int distanciaHasta) {
        {
            throw new JugadaInvalidaExepcion("La unidad no cura");
        }

    }
}