package grupo.N6.algochess;

import grupo.N6.algochess.acciones.Atacar;
import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.unidades.Jinete;
import grupo.N6.algochess.unidades.SoldadoDeInfanteria;
import org.junit.Assert;
import org.junit.Test;

public class AtacarTest {
    @Test
    public void test01AtacarUnidad() {

        Tablero tablero = new Tablero(10, 10);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1,1);
        Coordenada ubicacionFinal = new Coordenada(1,2);
        tablero.ponerUnidad(soldado1, ubicacionInicial);
        tablero.ponerUnidad(soldado2,ubicacionFinal);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionInicial),soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal),soldado2);
        Atacar atacar = new Atacar(ubicacionInicial, ubicacionFinal);
        atacar.ejecutarSobre(new Partida(new Jugador("Pedro"), new Jugador("Juan")), tablero);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal).getVida(),90);
    }

    @Test(expected = DistanciaInvalidaExepcion.class)
    public void test02AtacarUnidadFallaAlExcederDistancia() {

        Tablero tablero = new Tablero(10, 10);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1, 1);
        Coordenada ubicacionFinal = new Coordenada(1, 3);
        tablero.ponerUnidad(soldado1, ubicacionInicial);
        tablero.ponerUnidad(soldado2, ubicacionFinal);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionInicial), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal), soldado2);
        Atacar atacar = new Atacar(ubicacionInicial, ubicacionFinal);
        atacar.ejecutarSobre(new Partida(new Jugador("Pedro"), new Jugador("Juan")), tablero);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal).getVida(), 100);
    }

    @Test
    public void test03JineteAtacaModoEspada() {

        Tablero tablero = new Tablero(10, 10);
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1, 1);
        Coordenada ubicacionFinal = new Coordenada(1, 2);
        tablero.ponerUnidad(jinete, ubicacionInicial);
        tablero.ponerUnidad(soldado, ubicacionFinal);
        Atacar atacar = new Atacar(ubicacionInicial, ubicacionFinal);
        atacar.ejecutarSobre(new Partida(new Jugador("Pedro"), new Jugador("Juan")), tablero);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal).getVida(), 95);
    }

    @Test
    public void test03JineteAtacaModoArco() {

        Tablero tablero = new Tablero(10, 10);
        Jinete jinete = new Jinete();
        jinete.cambiarModo();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1, 1);
        Coordenada ubicacionFinal = new Coordenada(1, 4);
        tablero.ponerUnidad(jinete, ubicacionInicial);
        tablero.ponerUnidad(soldado, ubicacionFinal);
        Atacar atacar = new Atacar(ubicacionInicial, ubicacionFinal);
        atacar.ejecutarSobre(new Partida(new Jugador("Pedro"), new Jugador("Juan")), tablero);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal).getVida(), 85);
    }
}