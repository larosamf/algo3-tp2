package grupo.N6.algochess;

import grupo.N6.algochess.accionesDePartida.Atacar;
import grupo.N6.algochess.accionesDePartida.Curar;
import grupo.N6.algochess.exepciones.DistanciaInvalidaExepcion;
import grupo.N6.algochess.exepciones.JugadaInvalidaExepcion;
import grupo.N6.algochess.posicionables.unidades.Catapulta;
import grupo.N6.algochess.posicionables.unidades.Curandero;
import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurarTest {
    @Test
    public void test01CurarUnidadMaximaVida() {

        //Arrange:
    	Tablero tablero = new Tablero(10, 10);
        Curandero curandero = new Curandero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1,1);
        Coordenada ubicacionFinal = new Coordenada(1,2);
        tablero.ponerUnidad(curandero, ubicacionInicial);
        tablero.ponerUnidad(soldado,ubicacionFinal);
        
        //Act:
        Curar curar = new Curar(ubicacionInicial, ubicacionFinal);
        curar.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);
        
        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal).getVida(),100);
    }
    @Test
    public void test02CurarUnidadConDano() {

        //Arrange:
    	Partida partida = new Partida(new Jugador(), new Jugador());
        Tablero tablero = new Tablero(10, 10);
        Curandero curandero = new Curandero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1,1);
        Coordenada ubicacionFinal = new Coordenada(1,2);
        tablero.ponerUnidad(curandero, ubicacionInicial);
        tablero.ponerUnidad(soldado,ubicacionFinal);

        //Act y Assert:
        Atacar atacar = new Atacar(ubicacionFinal,ubicacionInicial);
        atacar.ejecutarSobre(partida,tablero);
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionInicial).getVida(),65);
        Curar curar = new Curar(ubicacionInicial, ubicacionInicial);
        curar.ejecutarSobre(partida, tablero);
        Assert.assertEquals(75,tablero.unidadEnCasillero(ubicacionInicial).getVida());
    }
    @Test(expected = DistanciaInvalidaExepcion.class)
    public void test02AtacarUnidadFallaAlExcederDistancia() {

        //Arrange:
        Tablero tablero = new Tablero(10, 10);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada ubicacionInicial = new Coordenada(1, 1);
        Coordenada ubicacionFinal = new Coordenada(1, 7);
        tablero.ponerUnidad(curandero, ubicacionInicial);
        tablero.ponerUnidad(soldado, ubicacionFinal);

        //Act:
        Curar curar = new Curar(ubicacionInicial, ubicacionFinal);
        curar.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal).getVida(), 100);
    }
    
    @Test(expected = JugadaInvalidaExepcion.class)
    public void test04CatapultaNoPuedeSerCuradaPorElCurandero() {
        
    	//Arrange
    	Tablero tablero = new Tablero(10, 10);
        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionSoldado = new Coordenada(1, 1);
        Coordenada ubicacionInicial = new Coordenada(1, 2);
        Coordenada ubicacionFinal = new Coordenada(2, 1);
        tablero.ponerUnidad(curandero, ubicacionInicial);
        tablero.ponerUnidad(soldado, ubicacionSoldado);
        tablero.ponerUnidad(catapulta, ubicacionFinal);

        //Act:
        Atacar atacar = new Atacar(ubicacionSoldado, ubicacionFinal);
        atacar.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);
        Curar curar = new Curar(ubicacionInicial, ubicacionFinal);
        curar.ejecutarSobre(new Partida(new Jugador(), new Jugador()), tablero);

        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionFinal).getVida(), 40);
    }
}