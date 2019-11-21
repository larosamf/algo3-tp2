package grupo.N6.algochess.posicionables;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.accionesDeJuego.Ataque;
import grupo.N6.algochess.accionesDeJuego.AtaqueExpansivo;
import grupo.N6.algochess.accionesDeJuego.AtaqueNormal;

import java.util.Calendar;

public interface Atacable {

    public void recibirAtaque(AtaqueExpansivo ataqueExpansivo);

    public void recibirAtaque(AtaqueNormal ataqueNormal);

    void recibirDano(int dmg);

}