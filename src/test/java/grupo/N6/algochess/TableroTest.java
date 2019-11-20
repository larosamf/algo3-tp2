package grupo.N6.algochess;

import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;
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
    public void test02PonerUnidad() {
        
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
    public void test03SeObtienerElCasilleroDeArriba() {
        
    	//Arrange y Act:
    	Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroArriba = new Coordenada(2,1);
        
        //Assert:
        Assert.assertEquals(true, tablero.obtenerCasilleroDeArribaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroArriba));

    }

    @Test
    public void test04SeObtienerElCasilleroDeLaDerecha() {
        
    	//Arrange y Act:
    	Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroDerecha = new Coordenada(3,2);
        
        //Assert:
        Assert.assertEquals(true, tablero.obtenerCasilleroDeDerechaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroDerecha));
    }

    @Test
    public void test05SeObtienerElCasilleroDeAbajo() {
        
    	//Arrange y Act:
    	Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroDerecha = new Coordenada(2,3);
        
        //Assert:
        Assert.assertEquals(true, tablero.obtenerCasilleroDeAbajoDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroDerecha));
    }


    @Test
    public void test06SeObtienerElCasilleroDeLaIzquierda() {
        
    	//Arrange y Act:
    	Tablero tablero = new Tablero(10,10);
        Coordenada ubicacionCasilleroInicial = new Coordenada(2,2);
        Coordenada ubicacionCasilleroIzquierda = new Coordenada(1,2);
        
        //Assert:
        Assert.assertEquals(true, tablero.obtenerCasilleroDeIzquierdaDe(ubicacionCasilleroInicial).estaEnPosicion(ubicacionCasilleroIzquierda));
    }

}

