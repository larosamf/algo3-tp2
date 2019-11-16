package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;


public class CasilleroTest {

    @Test
    public void test01elCasilleroSeCreaVacio(){
        //Arrange
        Casillero casillero = new Casillero(1,1,"Bando1");

        //Act y Assert
        assertThrows(EsteCasilleroYaEstaDesocupadoException.class,
                ()->{
                    casillero.desocupar();;
                });
    }

    @Test
    public void test02SePuedeAgregarUnSoldadoDeInfanteriaAlCasillero(){
       //Arrange
        Casillero casillero = new Casillero(2,2,"Bando1");
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        //Act
        casillero.ocuparPor(soldadoDeInfanteria, "Bando1");

        //Assert
        assertEquals(soldadoDeInfanteria, casillero.getUnidadEnElCasillero());
    }

}
