package grupo.N6.algochess.modos;

import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.unidades.Unidad;

public abstract class ModoJinete {

    private int ptosAtaque;
    private int distAtaqueDesde;
    private int distAtaqueHasta;

    protected ModoJinete(int ataque, int desde, int hasta) {
        this.ptosAtaque = ataque;
        this.distAtaqueDesde = desde;
        this.distAtaqueHasta = hasta;
    }
    public void atacar(Unidad atacado, int distancia){
        if (distAtaqueHasta < distancia & distAtaqueDesde > distancia)
            throw new DistanciaInvalidaExepcion("Esta fuera de rango.");
        atacado.recibirAtaque(ptosAtaque);
    }
}
