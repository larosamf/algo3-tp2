package grupo.N6.algochess.unidades;

public class Jinete extends UnidadMovible {

    public Jinete() {
        _VIDAMAXIMA_ = 100;
        vida = 100;
        costo = 2;
        distanciaAccion = 1;
    }

    @Override
    public void atacar(Unidad unidad, int distancia) {

    }

    @Override
    public void terminarTurno() {

    }

    @Override
    public void curar(Unidad curado, int distanciaHasta) {

    }

}
