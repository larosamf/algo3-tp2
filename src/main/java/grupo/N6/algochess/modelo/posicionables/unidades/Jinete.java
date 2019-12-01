package grupo.N6.algochess.modelo.posicionables.unidades;

import java.util.ArrayList;

import grupo.N6.algochess.modelo.Casillero;
import grupo.N6.algochess.modelo.modos.JineteArco;
import grupo.N6.algochess.modelo.modos.JineteEspada;
import grupo.N6.algochess.modelo.modos.ModoJinete;
import grupo.N6.algochess.modelo.posicionables.Atacable;

public class Jinete extends Unidad {

    private ModoJinete modoActivo;
    private ModoJinete modoInactivo;
    private ModoJinete modoEspada;
    private ModoJinete modoArco;

    public Jinete() {
        _VIDAMAXIMA_ = 100;
        vida = 100;
        costo = 2;
        modoEspada = new JineteEspada();
        modoArco = new JineteArco();
        modoActivo = modoEspada;
        modoInactivo = modoArco;
        nombre = "jinete";
    }

    @Override
    public void atacar(Atacable atacable, int distancia) {
        this.modoActivo.atacar(atacable,distancia);
    }

    @Override
    public void terminarTurno() {

    }

    @Override
    public void curar(Unidad curado, int distanciaHasta) {

    }

    public void mover(Casillero casilleroInicio, Casillero casilleroFin) {
    	casilleroInicio.moverUnidadA(casilleroFin);
    }

    public void cambiarModo(){
        ModoJinete aux = modoActivo;
        modoActivo = modoInactivo;
        modoInactivo = aux;
    }
    
    private boolean haySoldado(ArrayList<Unidad> unidadesAliadas) {
    	for (Unidad unidadAliada : unidadesAliadas) {
    		if (unidadAliada.esSoldado())
    			return true;
    	}
    	return false;
    }
    
    public void actualizarEstado(ArrayList<Unidad> aliadosACortaDistancia, ArrayList<Unidad> enemigosACortaDistancia, ArrayList<Unidad> batallon) {
    	if (haySoldado(aliadosACortaDistancia) && enemigosACortaDistancia.isEmpty()) {
    		modoActivo = modoArco;
    		modoInactivo = modoEspada;
    	}else{
    		modoActivo = modoEspada;
    		modoInactivo = modoArco;
    	}
    }

}