package grupo.N6.algochess.accionesDeJuego;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.exepciones.CasilleroVacioException;
import grupo.N6.algochess.exepciones.UnidadAfectadaExeption;
import grupo.N6.algochess.posicionables.unidades.Unidad;

import java.util.ArrayList;

public class AtaqueExpansivo extends Ataque {


    public AtaqueExpansivo(int dmg) {
        super(dmg);
    }

    @Override
    public void efectuarSobre(Casillero casillero) {
        aplicarDmg(casillero,DMG);

    }

    @Override
    public void efectuarSobre(Unidad unidad) {
        unidad.recibirDano(DMG);
    }


    public static void aplicarDmg(final Casillero casillero, final int DMG) {
        try {
            casillero.obtenerUnidad().recibirDano(DMG);
        } catch (CasilleroVacioException | UnidadAfectadaExeption e) {
            return;
        }
        for (Casillero cas : casillero.obtenerAdyacencias())
            aplicarDmg(cas, DMG);
    }
}
