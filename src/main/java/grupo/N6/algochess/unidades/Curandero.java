package grupo.N6.algochess.unidades;

import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.exepciones.JugadaInvalidaExepcion;

public class Curandero extends UnidadMovible {

    int curacion;

	public Curandero() {
		vida = 75;
		costo = 2;
		curacion = 15;
	}
	@Override
	public void atacar(Unidad atacado, int distancia) {
			throw new JugadaInvalidaExepcion("La unidad no ataca");
	}

    @Override
    public void terminarTurno() {

    }

    public void curar(Unidad curado, int distancia) {
		if(distancia>distanciaAccion) {
			throw new DistanciaInvalidaExepcion("maximo de 1");
		}
		curado.recibirCuracion(curacion);
	}

}