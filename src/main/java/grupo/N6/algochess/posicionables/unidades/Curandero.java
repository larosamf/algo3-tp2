package grupo.N6.algochess.posicionables.unidades;

import java.util.ArrayList;

import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.exepciones.JugadaInvalidaExepcion;
import grupo.N6.algochess.posicionables.Atacable;

public class Curandero extends UnidadMovible {

    private int curacion;

	public Curandero() {
		_VIDAMAXIMA_ = 75;
		vida = 75;
		costo = 2;
		curacion = 15;
		distanciaAccion = 2;
	}
	@Override
	public void atacar(Atacable atacable, int distancia) {
			throw new JugadaInvalidaExepcion("La unidad no ataca");
	}

    @Override
    public void terminarTurno() {

    }

    public void curar(Unidad curado, int distancia) {
		if(distancia>distanciaAccion) {
			throw new DistanciaInvalidaExepcion("maximo de 2");
		}
		curado.recibirCuracion(curacion);
	}
    
    public void actualizarEstado(ArrayList<Unidad> aliadosACortaDistancia, ArrayList<Unidad> enemigosACortaDistancia, ArrayList<Unidad> batallon) {
    	
    }

}