package grupo.N6.algochess;

import org.junit.Assert;
import org.junit.Test;

import grupo.N6.algochess.accionesDePartida.Atacar;
import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;

public class AlgochessTest {
    @Test
    public void test01GuardarNombreDeJugador() {
    	
    	//Arrange:
        Algochess juego = new Algochess();
        
        //Act:
        juego.ingresarNombreDeJugador("Martina");
        
        //Assert:
        Assert.assertEquals(juego.nombreJugadorActivo(),"Martina");
    }
    
    @Test
    public void test02GuardarNombreDelSegundoJugador() {
    	
    	//Arrange:
        Algochess juego = new Algochess();
        
        //Act:
        juego.ingresarNombreDeJugador("Martina");
        juego.terminarTurno();
        juego.ingresarNombreDeJugador("Luis");
        
        //Assert:
        Assert.assertEquals(juego.nombreJugadorActivo(),"Luis");
    }
    
    @Test
    public void test02LuegoDeTerminarDeIngresarElNombreDelSegundoJugadorEsTurnoDelPrimero() {
    	
    	//Arrange:
        Algochess juego = new Algochess();
        
        //Act:
        juego.ingresarNombreDeJugador("Martina");
        juego.terminarTurno();
        juego.ingresarNombreDeJugador("Luis");
        juego.terminarTurno();
        
        //Assert:
        Assert.assertEquals(juego.nombreJugadorActivo(),"Martina");
    }
    
    @Test
    public void test03TamañoDelTableroEs20() {
    	
    	//Arrange:
        Algochess juego = new Algochess();
        
        //Act y Assert:
        Assert.assertEquals(juego.tamañoDeTablero(),20);
    }
    
    /*@Test
    public void test04SeColocoUnidadYSeObtieneSuNombre() {
    	
    	//Arrange:
        Algochess juego = new Algochess();
        
        //Act
        juego.colocarUnidad("jinete", 3, 3);
        
        //Assert
        Assert.assertEquals(juego.tipoUnidadEnCasillero(3, 3), "jinete");
    }*/
    
    @Test
    public void test05NoSeColocoUnidadYSeObtieneNullComoTipoDeUnidadEnUnCasilleroVacio() {
    	
    	//Arrange:
        Algochess juego = new Algochess();

        //Assert
        Assert.assertEquals(juego.tipoUnidadEnCasillero(3, 3), null);
    }
    
}
