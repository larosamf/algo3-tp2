package grupo.N6.algochess.modos;

import grupo.N6.algochess.accionesDeJuego.AtaqueExpansivo;
import grupo.N6.algochess.accionesDeJuego.AtaqueNormal;

public class EstadoAtacado extends EstadoUnidad {

    public int aplicar(int dmg, int vida) {
        return vida;
    }
    @Override
    public boolean estaAtacado() {
        return true;
    }
}
