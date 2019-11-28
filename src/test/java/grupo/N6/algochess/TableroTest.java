package grupo.N6.algochess;

import grupo.N6.algochess.exepciones.CasilleroOcupadoException;
import grupo.N6.algochess.exepciones.NoSePuedeColocarUnaUnidadEnElSectorEnemigoException;
import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void test01CrearTablero() {
    	
    	//Arrange y Act:
        Tablero tablero = new Tablero(10, 10);
        
        //Assert:
        Assert.assertEquals(tablero.cantidadCasilleros(),100);
    }

    @Test
    public void test02SePuedeAgregarUnSoldadoDeInfanteriaEnCasilleroVacioDelSectorAliado() {
        
    	//Arrange:
    	Tablero tablero = new Tablero(10, 10);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacionInicial = new Coordenada(1,1);
        
        //Act:
        tablero.ponerUnidad(soldado, ubicacionInicial);
        
        //Assert:
        Assert.assertEquals(tablero.unidadEnCasillero(ubicacionInicial),soldado);
    }
    
    @Test
    public void test03NoSePuedeAgregarUnSoldadoDeInfanteriaEnCasilleroOcupadoDelSectorAliado(){
        //Arrange
        Tablero tablero = new Tablero(10,10);
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();
        SoldadoDeInfanteria otroSoldadoDeInfanteria = new SoldadoDeInfanteria();
        Coordenada ubicacion1 = new Coordenada(2,2);
        
        //Act
        tablero.ponerUnidad(soldadoDeInfanteria,ubicacion1);

        //Assert
        assertThrows(CasilleroOcupadoException.class,
                ()->{
                    tablero.ponerUnidad(otroSoldadoDeInfanteria,ubicacion1);
                });

    }
    
    @Test
    public void test04NoSePuedeAgregarUnSoldadoDeInfanteriaEnCasilleroDelSectorEnemigo(){
        //Arrange
        Tablero tablero = new Tablero(10,10);
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada ubicacion1 = new Coordenada(10,10);
        
        //Act y Assert
        assertThrows(NoSePuedeColocarUnaUnidadEnElSectorEnemigoException.class,
                ()->{
                    tablero.ponerUnidad(soldado,ubicacion1);
                });

    }

    @Test
    public void test05SeObtieneElCasilleroDeArriba() {
        
    	//Arrange y Act:
    	Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroArriba = new Coordenada(2,1);
        
        //Assert:
        Assert.assertEquals(true, tablero.obtenerCasilleroDeArribaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroArriba));

    }

    @Test
    public void test06SeObtieneElCasilleroDeLaDerecha() {
        
    	//Arrange y Act:
    	Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroDerecha = new Coordenada(3,2);
        
        //Assert:
        Assert.assertEquals(true, tablero.obtenerCasilleroDeDerechaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroDerecha));
    }

    @Test
    public void test07SeObtieneElCasilleroDeAbajo() {
        
    	//Arrange y Act:
    	Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroDerecha = new Coordenada(2,3);
        
        //Assert:
        Assert.assertEquals(true, tablero.obtenerCasilleroDeAbajoDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroDerecha));
    }


    @Test
    public void test08SeObtieneElCasilleroDeLaIzquierda() {
        
    	//Arrange y Act:
    	Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroIzquierda = new Coordenada(1,2);
        
        //Assert:
        Assert.assertEquals(true, tablero.obtenerCasilleroDeIzquierdaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroIzquierda));
    }

    @Test
    public void test06SeObtieneElCasilleroDeArribaALaDerecha() {

        //Arrange y Act:
        Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroDerecha = new Coordenada(3,1);

        //Assert:
        Assert.assertEquals(true, tablero.obtenerCasilleroDeArribaALaDerechaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroDerecha));
    }

}

