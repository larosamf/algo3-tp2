package grupo.N6.algochess.posicionables.unidades;

import java.util.ArrayList;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.exepciones.JugadaInvalidaExepcion;
import grupo.N6.algochess.posicionables.unidades.Unidad;
import grupo.N6.algochess.posicionables.unidades.UnidadMovible;

public class SoldadoDeInfanteria extends UnidadMovible {
	
	ArrayList<Unidad> batallon = new ArrayList<>();

	public SoldadoDeInfanteria() {
        _VIDAMAXIMA_ = 100;
		vida = 100;
		costo = 1;
		dano = 10;
		distanciaAccion = 1;
		batallon = null;
	}

	@Override
	public void atacar(Unidad atacado, int distancia) {
		if(distancia>distanciaAccion) {
            throw new DistanciaInvalidaExepcion("maximo de 1");
        }
        atacado.recibirAtaque(dano);
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
    
    @Override
    public boolean esSoldado() {
    	return true;
    }
    
    public void actualizarEstado(ArrayList<Unidad> aliados, ArrayList<Unidad> enemigos, ArrayList<Unidad> batallon) {
    	this.batallon = batallon;
    }
    
    @Override
    public void mover(Casillero casilleroInicio, Casillero casilleroFin) {
    	if (batallon != null) {
    		for (Unidad soldado : batallon) {
    			/*soldado.mover(desdeCasillero, hastaCasillero);*/
    		}	
    	}
    	
    	casilleroInicio.moverUnidadA(casilleroFin);
    }
   
    
    
    
    
    
}