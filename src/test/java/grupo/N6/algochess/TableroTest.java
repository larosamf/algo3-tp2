package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void test02SePuedeAgregarUnSoldadoDeInfanteriaEnCasilleroVacioDelSectorAliado(){
        //Arrange
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        //Act
        tablero.ubicarUnidadEnCasillero(soldadoDeInfanteria,6,8);

        //Assert
        assertEquals(soldadoDeInfanteria,tablero.getUnidadEnCasillero(6,8));

    }
    
    @Test
    public void test03NoSePuedeAgregarUnSoldadoDeInfanteriaEnCasilleroOcupadoDelSectorAliado(){
        //Arrange
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();
        SoldadoDeInfanteria otroSoldadoDeInfanteria = new SoldadoDeInfanteria();
        
        //Act
        tablero.ubicarUnidadEnCasillero(soldadoDeInfanteria,6,8);

        //Assert
        assertThrows(EsteCasilleroEstaOcupadoYNoSePuedePonerOtraUnidadException.class,
                ()->{
                    tablero.ubicarUnidadEnCasillero(otroSoldadoDeInfanteria,6,8);
                });

    }
    
    @Test
    public void test04NoSePuedeAgregarUnSoldadoDeInfanteriaEnCasilleroDelSectorEnemigo(){
        //Arrange
        Tablero tablero = new Tablero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        //Act yAssert
        assertThrows(NoSePuedeColocarUnaUnidadEnElSectorEnemigoException.class,
                ()->{
                	tablero.ubicarUnidadEnCasillero(soldadoDeInfanteria,19,19);;
                });

    }
    
}
