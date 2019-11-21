package grupo.N6.algochess.accionesDeJuego;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.posicionables.Atacable;
import grupo.N6.algochess.posicionables.unidades.Unidad;

public abstract class Ataque {

    protected int DMG;

    Ataque(int dmg){
        this.DMG = dmg;
    };

    abstract void efectuarSobre(Casillero casillero);

    abstract void efectuarSobre(Unidad unidad);


}
