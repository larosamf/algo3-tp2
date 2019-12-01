package grupo.N6.algochess.modelo.modos;

import grupo.N6.algochess.modelo.accionesDeJuego.AtaqueNormal;
import grupo.N6.algochess.modelo.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.modelo.posicionables.Atacable;

public abstract class ModoJinete {

    private int ptosAtaque;
    private int distAtaqueDesde;
    private int distAtaqueHasta;

    protected ModoJinete(int ataque, int desde, int hasta) {
        this.ptosAtaque = ataque;
        this.distAtaqueDesde = desde;
        this.distAtaqueHasta = hasta;
    }
    public void atacar(Atacable atacado, int distancia){
        if (distAtaqueHasta < distancia || distAtaqueDesde > distancia)
            throw new DistanciaInvalidaExepcion("Esta fuera de rango.");
        atacado.recibirAtaque(new AtaqueNormal(ptosAtaque));
    }
}
