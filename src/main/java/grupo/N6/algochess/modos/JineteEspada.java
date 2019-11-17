package grupo.N6.algochess.modos;

import grupo.N6.algochess.modos.ModoJinete;
import grupo.N6.algochess.unidades.Unidad;


public class JineteEspada extends ModoJinete {

    private final static int JINETE_ESPADA_ATAQUE = 5;
    private final static int JINETE_ESPADA_DISTANCIA_DESDE = 1;
    private final static int JINETE_ESPADA_DISTANCIA_HASTA = 1;

    public JineteEspada() {
            super(JINETE_ESPADA_ATAQUE,
                    JINETE_ESPADA_DISTANCIA_DESDE,
                    JINETE_ESPADA_DISTANCIA_HASTA);
        }
}
