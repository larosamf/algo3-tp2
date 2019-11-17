package grupo.N6.algochess.unidades;

import grupo.N6.algochess.modos.JineteArco;
import grupo.N6.algochess.modos.JineteEspada;
import grupo.N6.algochess.modos.ModoJinete;

public class Jinete extends UnidadMovible {

    private ModoJinete modoActivo;
    private ModoJinete modoInactivo;

    public Jinete() {
        _VIDAMAXIMA_ = 100;
        vida = 100;
        costo = 2;
        modoActivo = new JineteEspada();
        modoInactivo = new JineteArco();
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

}
