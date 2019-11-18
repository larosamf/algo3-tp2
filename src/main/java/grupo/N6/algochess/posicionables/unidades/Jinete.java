package grupo.N6.algochess.posicionables.unidades;

import java.util.ArrayList;

import grupo.N6.algochess.modos.JineteArco;
import grupo.N6.algochess.modos.JineteEspada;
import grupo.N6.algochess.modos.ModoJinete;
import grupo.N6.algochess.posicionables.unidades.Unidad;
import grupo.N6.algochess.posicionables.unidades.UnidadMovible;

public class Jinete extends UnidadMovible {

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
    }

    @Override
    public void atacar(Unidad unidad, int distancia) {
        this.modoActivo.atacar(unidad,distancia);
    }

    @Override
    public void terminarTurno() {

    }

    @Override
    public void curar(Unidad curado, int distanciaHasta) {

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
    
    public void actualizarEstado(ArrayList<Unidad> unidadesAliadasACortaDistancia, ArrayList<Unidad> unidadesEnemigasACortaDistancia) {
    	if (haySoldado(unidadesAliadasACortaDistancia) && unidadesEnemigasACortaDistancia.isEmpty())
    		modoActivo = modoArco;
    	modoActivo = modoEspada;
    }

}
