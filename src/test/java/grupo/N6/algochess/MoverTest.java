package grupo.N6.algochess;

import grupo.N6.algochess.unidades.SoldadoDeInfanteria;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoverTest {
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
}
