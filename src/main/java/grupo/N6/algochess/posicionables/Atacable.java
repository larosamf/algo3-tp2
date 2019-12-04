package grupo.N6.algochess.posicionables;

import grupo.N6.algochess.accionesDeJuego.AtaqueExpansivo;
import grupo.N6.algochess.accionesDeJuego.AtaqueNormal;

public interface Atacable {

    public void recibirAtaque(AtaqueExpansivo ataqueExpansivo);

    public void recibirAtaque(AtaqueNormal ataqueNormal);

    void recibirDano(int dmg);

}