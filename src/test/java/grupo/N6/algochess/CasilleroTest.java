package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CasilleroTest {

    @Test
    public void test01elCasilleroSeCreaVacio(){
        Casillero casillero = new Casillero();
        assertEquals(false ,casillero.estaOcupado());
    }

    @Test
    public void test02SePuedeAgregarUnSoldadoDeInfanteriaAlCasillero(){
        Casillero casillero = new Casillero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        casillero.ocuparPor(soldadoDeInfanteria);

        assertEquals(soldadoDeInfanteria, casillero.desocupar());
    }

}
