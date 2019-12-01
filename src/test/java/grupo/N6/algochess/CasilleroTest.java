package grupo.N6.algochess;

import grupo.N6.algochess.modelo.Casillero;
import grupo.N6.algochess.modelo.Coordenada;
import org.junit.Assert;
import org.junit.Test;

public class CasilleroTest {

    @Test
    public void test01CasilleroSeCreaConCoordenada() {
    	
    	//Arrange:
        Coordenada coordenada = new Coordenada(1, 1);
        Casillero casillero = new Casillero(coordenada, "Bando1");
        
        //Act y Assert:
        Assert.assertTrue(casillero.estaEnPosicion(coordenada));
    }


}
