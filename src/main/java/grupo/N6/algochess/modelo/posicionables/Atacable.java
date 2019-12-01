package grupo.N6.algochess.modelo.posicionables;

import grupo.N6.algochess.modelo.accionesDeJuego.AtaqueExpansivo;
import grupo.N6.algochess.modelo.accionesDeJuego.AtaqueNormal;

public interface Atacable {

    public void recibirAtaque(AtaqueExpansivo ataqueExpansivo);

    public void recibirAtaque(AtaqueNormal ataqueNormal);

    void recibirDano(int dmg);

}