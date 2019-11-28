package grupo.N6.algochess;


import grupo.N6.algochess.accionesDePartida.Mover;
import grupo.N6.algochess.exepciones.CasilleroAlQueSeQuiereMoverEstaOcupadoException;
import grupo.N6.algochess.exepciones.CasilleroOcupadoException;
import grupo.N6.algochess.exepciones.MovimientoInvalidoException;
import grupo.N6.algochess.posicionables.unidades.Batallon;
import grupo.N6.algochess.posicionables.unidades.Jinete;
import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;
import grupo.N6.algochess.posicionables.unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

public class MoverTest {
    @Test
    public void test01MoverUnidad() {

        //Arrange:
        Tablero tablero = new Tablero(10, 10);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1, 1);
        Coordenada ubicacionFinal = new Coordenada(1, 2);
        tablero.ponerUnidad(soldado, ubicacionInicial);

        //Act:
        Mover mover = new Mover(ubicacionInicial, ubicacionFinal);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal), soldado);
    }

    @Test
    public void test02SoldadoNoSePuedeMoverAUnCasilleroNoAdyacente() {
        //Arrange
        Tablero tablero = new Tablero(10, 10);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(3, 3);
        Coordenada ubicacionFinal = new Coordenada(1, 4);
        Casillero casilleroInicio = new Casillero(ubicacionInicial, "Bando1");
        Casillero casilleroFinal = new Casillero(ubicacionFinal, "Bando1");
        tablero.ponerUnidad(soldado, ubicacionInicial);

        //Act y Assert
        assertThrows(MovimientoInvalidoException.class,
                () -> {
                    soldado.mover(casilleroInicio, casilleroFinal);
                });
    }

    @Test
    public void test03SoldadoNoSePuedeMoverAUnCasilleroOcupado() {
        //Arrange
        Tablero tablero = new Tablero(10, 10);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(3, 3);
        Coordenada ubicacionFinal1 = new Coordenada(3, 4);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionFinal1);

        Mover mover = new Mover(ubicacionInicial1, ubicacionFinal1);


        //Act y Assert
        assertThrows(CasilleroAlQueSeQuiereMoverEstaOcupadoException.class,
                () -> {
                    mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);;
                });
    }



    @Test
    public void test03MoverBatallonHorizontalArriba() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(2, 1);
        Coordenada ubicacionInicial2 = new Coordenada(3, 2);
        Coordenada ubicacionFinal2 = new Coordenada(3, 1);
        Coordenada ubicacionInicial3 = new Coordenada(4, 2);
        Coordenada ubicacionFinal3 = new Coordenada(4, 1);
        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);
        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "HORIZONTAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial2, ubicacionFinal2);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }

    @Test
    public void test04MoverBatallonHorizontalAbajo() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(2, 3);

        Coordenada ubicacionInicial2 = new Coordenada(3, 2);
        Coordenada ubicacionFinal2 = new Coordenada(3, 3);

        Coordenada ubicacionInicial3 = new Coordenada(4, 2);
        Coordenada ubicacionFinal3 = new Coordenada(4, 3);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "HORIZONTAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial2, ubicacionFinal2);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }

    @Test
    public void test05MoverBatallonHorizontalDerecha() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(3, 2);

        Coordenada ubicacionInicial2 = new Coordenada(3, 2);
        Coordenada ubicacionFinal2 = new Coordenada(4, 2);

        Coordenada ubicacionInicial3 = new Coordenada(4, 2);
        Coordenada ubicacionFinal3 = new Coordenada(5, 2);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "HORIZONTAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial1, ubicacionFinal1);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }

    @Test
    public void test06MoverBatallonHorizontalIzquierda() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(1, 2);

        Coordenada ubicacionInicial2 = new Coordenada(3, 2);
        Coordenada ubicacionFinal2 = new Coordenada(2, 2);

        Coordenada ubicacionInicial3 = new Coordenada(4, 2);
        Coordenada ubicacionFinal3 = new Coordenada(3, 2);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "HORIZONTAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial1, ubicacionFinal1);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }




    @Test
    public void test07MoverBatallonVerticalDerecha() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(3, 2);

        Coordenada ubicacionInicial2 = new Coordenada(2, 3);
        Coordenada ubicacionFinal2 = new Coordenada(3, 3);

        Coordenada ubicacionInicial3 = new Coordenada(2, 4);
        Coordenada ubicacionFinal3 = new Coordenada(3, 4);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "VERTICAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial1, ubicacionFinal1);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }

    @Test
    public void test08MoverBatallonVerticalIzquierda() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(1, 2);

        Coordenada ubicacionInicial2 = new Coordenada(2, 3);
        Coordenada ubicacionFinal2 = new Coordenada(1, 3);

        Coordenada ubicacionInicial3 = new Coordenada(2, 4);
        Coordenada ubicacionFinal3 = new Coordenada(1, 4);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "VERTICAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial1, ubicacionFinal1);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }

    @Test
    public void test09MoverBatallonVerticalArriba() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(2, 3);

        Coordenada ubicacionInicial2 = new Coordenada(2, 3);
        Coordenada ubicacionFinal2 = new Coordenada(2, 4);

        Coordenada ubicacionInicial3 = new Coordenada(2, 4);
        Coordenada ubicacionFinal3 = new Coordenada(2, 5);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "VERTICAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial1, ubicacionFinal1);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }

    @Test
    public void test10MoverBatallonVerticalAbajo() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(2, 1);

        Coordenada ubicacionInicial2 = new Coordenada(2, 3);
        Coordenada ubicacionFinal2 = new Coordenada(2, 2);

        Coordenada ubicacionInicial3 = new Coordenada(2, 4);
        Coordenada ubicacionFinal3 = new Coordenada(2, 3);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "VERTICAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial1, ubicacionFinal1);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }

    @Test
    public void test11MoverBatallonVerticalArribaALaDerecha() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();

        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(3, 3);

        Coordenada ubicacionInicial2 = new Coordenada(2, 3);
        Coordenada ubicacionFinal2 = new Coordenada(3, 4);

        Coordenada ubicacionInicial3 = new Coordenada(2, 4);
        Coordenada ubicacionFinal3 = new Coordenada(3, 5);

        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "VERTICAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial3, ubicacionFinal3);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }

    @Test
    public void test08MoverBatallonVerticalIzquierdaPeroHayUnJineteEnElCaminoDeUnSoldadoYSeMuevenLosOtrosDos() {

        //Arrange:
        Tablero tablero = new Tablero(20, 20);
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Jinete jinete = new Jinete();

        Coordenada ubicacionJinete = new Coordenada(1,3);

        Coordenada ubicacionInicial1 = new Coordenada(2, 2);
        Coordenada ubicacionFinal1 = new Coordenada(1, 2);

        /*SE QUEDA EN EL LUGAR PORQUE EL JINETE OCUPA SU CAMINO*/
        Coordenada ubicacionInicial2 = new Coordenada(2, 3);
        Coordenada ubicacionFinal2 = new Coordenada(2, 3);

        Coordenada ubicacionInicial3 = new Coordenada(2, 4);
        Coordenada ubicacionFinal3 = new Coordenada(1, 4);

        tablero.ponerUnidad(jinete, ubicacionJinete);
        tablero.ponerUnidad(soldado1, ubicacionInicial1);
        tablero.ponerUnidad(soldado2, ubicacionInicial2);
        tablero.ponerUnidad(soldado3, ubicacionInicial3);

        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);

        Batallon unBatallon = new Batallon(batallon, "VERTICAL");

        soldado1.setBatallon(unBatallon);
        soldado2.setBatallon(unBatallon);
        soldado3.setBatallon(unBatallon);

        //Act:
        Mover mover = new Mover(ubicacionInicial1, ubicacionFinal1);
        mover.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal1), soldado1);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal2), soldado2);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal3), soldado3);

    }



}