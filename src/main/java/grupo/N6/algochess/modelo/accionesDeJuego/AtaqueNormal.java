package grupo.N6.algochess.modelo.accionesDeJuego;

import grupo.N6.algochess.modelo.Casillero;
import grupo.N6.algochess.modelo.posicionables.unidades.Unidad;

public class AtaqueNormal extends Ataque{

    public AtaqueNormal(int dmg) {
        super(dmg);
    }

    @Override
    public void efectuarSobre(Casillero casillero) {

    }

    @Override
    public void efectuarSobre(Unidad unidad) {
        unidad.recibirDano(DMG);
    }
}
