package grupo.N6.algochess;

import grupo.N6.algochess.unidades.SoldadoDeInfanteria;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void test01CrearTablero() {
        Tablero tablero = new Tablero(10, 10);
        Assert.assertEquals(tablero.cantidadCasilleros(),100);
    }

    @Test
        public void test02PonerUnidad() {
        Tablero tablero = new Tablero(10, 10);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1,1);
        tablero.ponerUnidad(soldado, ubicacionInicial);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionInicial),soldado);
    }
}

