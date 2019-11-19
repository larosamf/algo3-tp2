package grupo.N6.algochess;

import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;
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

    @Test
    public void testSeObtienerElCasilleroDeArriba() {
        Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroArriba = new Coordenada(2,1);
        Assert.assertEquals(true, tablero.obtenerCasilleroDeArribaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroArriba));

    }

    @Test
    public void testSeObtienerElCasilleroDeLaDerecha() {
        Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroDerecha = new Coordenada(3,2);
        Assert.assertEquals(true, tablero.obtenerCasilleroDeDerechaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroDerecha));
    }

    @Test
    public void testSeObtienerElCasilleroDeLaIzquierda() {
        Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroIzquierda = new Coordenada(1,2);
        Assert.assertEquals(true, tablero.obtenerCasilleroDeIzquierdaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroIzquierda));
    }

}

