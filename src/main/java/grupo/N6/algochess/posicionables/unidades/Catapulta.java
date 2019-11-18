package grupo.N6.algochess.posicionables.unidades;

import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.exepciones.JugadaInvalidaExepcion;
import grupo.N6.algochess.Casillero;


public class Catapulta extends Unidad {
	
	public Catapulta() {
		distanciaAccion = 6;
		vida = 50;
		costo = 5;
		dano = 20;
	}

	@Override
	public void atacar(Unidad atacado, int distancia) {
		if(distancia<distanciaAccion) {
			throw new DistanciaInvalidaExepcion("No ataca a corta distancia");
		}
		atacado.recibirAtaque(dano);//ataque ataque.recibirAtaque
	}

	@Override
	public void terminarTurno() {

	}

	@Override
	public void curar(Unidad curado, int distanciaHasta) {
	    throw new JugadaInvalidaExepcion("La unidad no ataca");
	}

    @Override
    public void mover(Casillero inicio, Casillero fin) {
        throw new JugadaInvalidaExepcion("La unidad no se mueve");
    }

}