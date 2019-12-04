package grupo.N6.algochess.modos;


public class JineteArco extends ModoJinete {

    private final static int JINETE_ARCO_ATAQUE = 15;
    private final static int JINETE_ARCO_DISTANCIA_DESDE = 3;
    private final static int JINETE_ARCO_DISTANCIA_HASTA = 5;

    public JineteArco() {
        super(JINETE_ARCO_ATAQUE,
                JINETE_ARCO_DISTANCIA_DESDE,
                JINETE_ARCO_DISTANCIA_HASTA);
    }
}
