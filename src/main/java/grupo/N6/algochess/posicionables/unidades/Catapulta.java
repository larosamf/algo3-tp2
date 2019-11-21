package grupo.N6.algochess.posicionables.unidades;

import grupo.N6.algochess.accionesDeJuego.AtaqueExpansivo;
import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.exepciones.JugadaInvalidaExepcion;

import java.util.ArrayList;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.posicionables.Atacable;


public class Catapulta extends Unidad {
	
	public Catapulta() {
		distanciaAccion = 6;
		vida = 50;
		costo = 5;
		dano = 20;
	}

	@Override
	public void atacar(Atacable atacado, int distancia) {
		if(distancia<distanciaAccion) {
			throw new DistanciaInvalidaExepcion("No ataca a corta distancia");
		}
		AtaqueExpansivo ataque = new AtaqueExpansivo(dano);
		atacado.recibirAtaque(ataque);//ataque ataque.recibirAtaque
	}

	@Override
	public void terminarTurno() {

	}

	@Override
	public void curar(Unidad curado, int distanciaHasta) {
	    throw new JugadaInvalidaExepcion("La unidad no cura");
	}

    @Override
    public void mover(Casillero inicio, Casillero fin) {
        throw new JugadaInvalidaExepcion("La unidad no se mueve");
    }
    
    @Override
    public void recibirCuracion(int cura) {
    	throw new JugadaInvalidaExepcion("La unidad no puede recibir curacion");
    }
    
    public void actualizarEstado(ArrayList<Unidad> aliadosACortaDistancia, ArrayList<Unidad> enemigosACortaDistancia, ArrayList<Unidad> batallon) {
    	
    }

}