package grupo.N6.algochess.posicionables.unidades;

import java.util.ArrayList;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.accionesDeJuego.AtaqueNormal;
import grupo.N6.algochess.accionesDePartida.MoverBatallon;
import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.exepciones.JugadaInvalidaExepcion;
import grupo.N6.algochess.posicionables.Atacable;

public class SoldadoDeInfanteria extends Unidad {
	
	Batallon batallon = null;

	public SoldadoDeInfanteria() {
        _VIDAMAXIMA_ = 100;
		vida = 100;
		costo = 1;
		dano = 10;
		distanciaAccion = 1;
		batallon = null;
	}

	@Override
	public void atacar(Atacable atacado, int distancia, Atacable casillero) {
		if(distancia>distanciaAccion) {
            throw new DistanciaInvalidaExepcion("maximo de 1");
        }
        atacado.recibirAtaque(new AtaqueNormal(dano));
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
    	this.batallon = new Batallon(batallon, "HORIZONTAL"); //POR AHORA LO DEJO ASI PARA Q COMPILE
    }

    public void setBatallon(Batallon batallon){
	    this.batallon = batallon;
    }

    public void mover(Casillero casilleroInicio, Casillero casilleroFin) {
    	if (batallon != null) {
    	    MoverBatallon moverBatallon = new MoverBatallon(this.batallon, casilleroInicio, casilleroFin);
    	    moverBatallon.mover();
    	}else{
    	    casilleroInicio.moverUnidadA(casilleroFin);
        }
    }
    
    public Batallon obtenerBatallon() {
		return batallon;
	}


}