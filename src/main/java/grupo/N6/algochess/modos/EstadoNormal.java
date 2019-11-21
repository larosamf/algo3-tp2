package grupo.N6.algochess.modos;

import grupo.N6.algochess.accionesDeJuego.AtaqueExpansivo;
import grupo.N6.algochess.accionesDeJuego.AtaqueNormal;

public class EstadoNormal extends EstadoUnidad {

    public int aplicar(int dmg, int vida) {
        if (vida-dmg < 0)
            return 0;
        else
            return(vida - dmg);

    }

    @Override
    public boolean estaAtacado() {
        return false;
    }


}
