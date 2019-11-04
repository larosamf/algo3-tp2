package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;


public class CasilleroTest {

    @Test
    public void test01elCasilleroSeCreaVacio(){
       Casillero casillero = new Casillero();
        assertThrows(EsteCasilleroYaEstaDesocupadoException.class,
                ()->{
                    casillero.desocupar();;
                });
    }

    @Test
    public void test02SePuedeAgregarUnSoldadoDeInfanteriaAlCasillero(){
        Casillero casillero = new Casillero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        casillero.ocuparPor(soldadoDeInfanteria);

        assertEquals(soldadoDeInfanteria, casillero.getUnidadEnElCasillero());
    }

}
