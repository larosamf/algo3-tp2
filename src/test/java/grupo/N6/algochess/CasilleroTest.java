package grupo.N6.algochess;

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
