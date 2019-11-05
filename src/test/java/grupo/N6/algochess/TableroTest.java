package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import grupo.N6.algochess.exepciones.NoSePuedeColocarUnaUnidadEnElSectorEnemigoException;
import grupo.N6.algochess.unidades.SoldadoDeInfanteria;
import org.junit.Test;

public class TableroTest {

    @Test
    public void test01ElTableroSeCreaConElCasilleroFila2Columna2Vacio() {
        //Arrange y Act
        Tablero tablero = new Tablero();

        //Assert
        assertThrows(EsteCasilleroYaEstaDesocupadoException.class,
                ()->{
                    tablero.desocuparCasillero(2,2);
                });
    }

    @Test
    public void test02SePuedeAgregarUnSoldadoDeInfanteriaEnLaFila6Columna8(){
        //Arrange
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        //Act
        tablero.ubicarUnidadEnCasillero(soldadoDeInfanteria,6,8);

        //Assert
        assertEquals(soldadoDeInfanteria,tablero.getUnidadEnCasillero(6,8));

    }
}
