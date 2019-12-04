package grupo.N6.algochess.posicionables.unidades;

import java.util.ArrayList;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.accionesDeJuego.AtaqueNormal;
import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.exepciones.JugadaInvalidaExepcion;
import grupo.N6.algochess.posicionables.Atacable;

public class SoldadoDeInfanteria extends Unidad {
	
	ArrayList<Unidad> batallon = new ArrayList<>();
	SoldadoDeInfanteria liderDelBatallon = null;

	public SoldadoDeInfanteria() {
        _VIDAMAXIMA_ = 100;
		vida = 100;
		costo = 1;
		dano = 10;
		nombre = "soldado";
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

    public void setBatallon(ArrayList<Unidad> batallon){
	    this.batallon = batallon;
    }

    public void mover(Casillero casilleroInicio, Casillero casilleroFin) {
    	if (batallon != null) {
    	        moverBatallon(casilleroInicio, casilleroFin);
    	}else{
    	    casilleroInicio.moverUnidadA(casilleroFin);
        }
    }

    public void moverBatallon(Casillero casilleroInicio, Casillero casilleroFin){
	    if(casilleroFin == casilleroInicio.obtenerAdyacenteDerecha()) {
           moverBatallonALaDerecha(casilleroInicio, casilleroFin);
        }else if(casilleroFin == casilleroInicio.obtenerAdyacenteIzquierda()){
	       moverBatallonALaIzquierda(casilleroInicio, casilleroFin);
        }else {
            casilleroInicio.obtenerAdyacenteIzquierda().moverUnidadA(casilleroFin.obtenerAdyacenteIzquierda());
            casilleroInicio.moverUnidadA(casilleroFin);
            casilleroInicio.obtenerAdyacenteDerecha().moverUnidadA(casilleroFin.obtenerAdyacenteDerecha());
        }
    }

    public void moverBatallonALaDerecha(Casillero casilleroInicio, Casillero casilleroFin){
        casilleroInicio.obtenerAdyacenteDerecha().moverUnidadA(casilleroFin.obtenerAdyacenteDerecha());
        casilleroInicio.moverUnidadA(casilleroFin);
        casilleroInicio.obtenerAdyacenteIzquierda().moverUnidadA(casilleroFin.obtenerAdyacenteIzquierda());
	}

    public void moverBatallonALaIzquierda(Casillero casilleroInicio, Casillero casilleroFin){
        casilleroInicio.obtenerAdyacenteIzquierda().moverUnidadA(casilleroFin.obtenerAdyacenteIzquierda());
        casilleroInicio.moverUnidadA(casilleroFin);
	    casilleroInicio.obtenerAdyacenteDerecha().moverUnidadA(casilleroFin.obtenerAdyacenteDerecha());
    }
    
    


}