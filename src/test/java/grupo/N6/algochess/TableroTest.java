package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TableroTest {

    @Test
    public void test01ElTableroSeCreaConElCasilleroFila2Columna2Vacio() {
        //Arrange y Act
        Tablero tablero = new Tablero();

        //Assert
       assertEquals(false,  tablero.getCasilleroEn(2,2).estaOcupado() );
    }

    @Test
    public void test02SePuedeAgregarUnSoldadoDeInfanteriaEnLaFila6Columna8(){
        //Arrange
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        //Act
        tablero.ubicarUnidadEnCasillero(soldadoDeInfanteria,6,8);

        //Assert
        assertEquals(soldadoDeInfanteria,tablero.desocuparCasillero(6,8));

    }
}
