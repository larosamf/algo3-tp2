package grupo.N6.algochess;

import grupo.N6.algochess.accionesDePartida.Mover;
import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;
import org.junit.Assert;
import org.junit.Test;

public class MoverTest {
    @Test
    public void test01MoverUnidad() {

        Tablero tablero = new Tablero(10, 10);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1,1);
        Coordenada ubicacionFinal = new Coordenada(1,2);
        tablero.ponerUnidad(soldado, ubicacionInicial);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionInicial),soldado);
        Mover mover = new Mover(ubicacionInicial, ubicacionFinal);
        mover.ejecutarSobre(new Partida(new Jugador("Pedro"), new Jugador("Juan")), tablero);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal),soldado);
    }
}
