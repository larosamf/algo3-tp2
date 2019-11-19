package grupo.N6.algochess;

import grupo.N6.algochess.accionesDePartida.Mover;
import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;
import grupo.N6.algochess.posicionables.unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal),soldado);
    }

    @Test
    public void test02MoverBatallon(){
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(2,2);
        Coordenada ubicacionFinal1 = new Coordenada(2,1);

        Coordenada ubicacionInicial2 = new Coordenada(3,2);
        Coordenada ubicacionFinal2 = new Coordenada(3,1);

        Coordenada ubicacionInicial3 = new Coordenada(4,2);
        Coordenada ubicacionFinal3 = new Coordenada(4,1);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        soldado2.setBatallon(batallon);

        Mover mover = new Mover(ubicacionInicial2, ubicacionFinal2);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1),soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2),soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3),soldado3);

    }

}
