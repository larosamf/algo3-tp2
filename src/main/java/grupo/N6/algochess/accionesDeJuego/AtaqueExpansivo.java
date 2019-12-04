package grupo.N6.algochess.accionesDeJuego;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.exepciones.CasilleroVacioException;
import grupo.N6.algochess.posicionables.unidades.Unidad;

import java.util.ArrayList;

public class AtaqueExpansivo extends Ataque {

    ArrayList<Casillero> afectados = new ArrayList<Casillero>();

    public AtaqueExpansivo(int dmg) {
        super(dmg);
    }

    @Override
    public void efectuarSobre(Casillero casillero) {
        aplicarDmg(casillero,DMG);

    }

    @Override
    void efectuarSobre(Unidad unidad) {

    }


    public void aplicarDmg(final Casillero casillero, final int DMG) {
        if (afectados.contains(casillero))
            return;
        try {
            casillero.recibirDano(DMG);
        } catch (CasilleroVacioException e) {
            return;
        }
        afectados.add(casillero);
        for (Casillero cas : casillero.obtenerAdyacencias())
            aplicarDmg(cas, DMG);
    }
}
