package grupo.N6.algochess.modelo.accionesDeJuego;

import grupo.N6.algochess.modelo.Casillero;
import grupo.N6.algochess.modelo.posicionables.unidades.Unidad;

public abstract class Ataque {

    protected int DMG;

    Ataque(int dmg){
        this.DMG = dmg;
    };

    abstract void efectuarSobre(Casillero casillero);

    abstract void efectuarSobre(Unidad unidad);


}
