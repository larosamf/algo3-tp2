package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;


public class CasilleroTest {

    @Test
    public void test01elCasilleroSeCreaVacio(){
        //Arrange
        Casillero casillero = new Casillero();

        //Act y Assert
        assertThrows(EsteCasilleroYaEstaDesocupadoException.class,
                ()->{
                    casillero.desocupar();;
                });
    }

    @Test
    public void test02SePuedeAgregarUnSoldadoDeInfanteriaAlCasillero(){
       //Arrange
        Casillero casillero = new Casillero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        //Act
        casillero.ocuparPor(soldadoDeInfanteria);

        //Assert
        assertEquals(soldadoDeInfanteria, casillero.getUnidadEnElCasillero());
    }

}
