package grupo.N6.algochess.modelo.posicionables.unidades;

import java.util.ArrayList;

import grupo.N6.algochess.modelo.Casillero;
import grupo.N6.algochess.modelo.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.modelo.exepciones.JugadaInvalidaExepcion;
import grupo.N6.algochess.modelo.posicionables.Atacable;

public class Curandero extends Unidad {

    private int curacion;

	public Curandero() {
		_VIDAMAXIMA_ = 75;
		vida = 75;
		costo = 2;
		curacion = 15;
		distanciaAccion = 2;
		nombre = "curandero";
	}
	@Override
	public void atacar(Atacable atacable, int distancia) {
			throw new JugadaInvalidaExepcion("La unidad no ataca");
	}

    @Override
    public void terminarTurno() {

    }

    public void mover(Casillero casilleroInicio, Casillero casilleroFin) {
    	casilleroInicio.moverUnidadA(casilleroFin);
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