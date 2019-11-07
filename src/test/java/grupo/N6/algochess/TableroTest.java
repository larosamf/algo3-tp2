package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TableroTest {

    @Test
    public void test01ElTableroSeCreaConElCasilleroFila2Columna2Vacio() {
        //Arrange y Act
        Tablero tablero = Tablero.getInstanciaDeTablero();

        //Assert
        assertThrows(EsteCasilleroYaEstaDesocupadoException.class,
                ()->{
                    tablero.desocuparCasillero(2,2);
                });
    }

    @Test
    public void test02SePuedeAgregarUnSoldadoDeInfanteriaEnCasilleroVacioDelSectorAliado(){
        //Arrange
        Tablero tablero = Tablero.getInstanciaDeTablero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        //Act
        tablero.ubicarUnidadEnCasillero(soldadoDeInfanteria,6,8);

        //Assert
        assertEquals(soldadoDeInfanteria,tablero.getUnidadEnCasillero(6,8));

    }
    
    @Test
    public void test03NoSePuedeAgregarUnSoldadoDeInfanteriaEnCasilleroOcupadoDelSectorAliado(){
        //Arrange
        Tablero tablero = Tablero.getInstanciaDeTablero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();
        SoldadoDeInfanteria otroSoldadoDeInfanteria = new SoldadoDeInfanteria();
        
        //Act
        tablero.ubicarUnidadEnCasillero(soldadoDeInfanteria,10,10);

        //Assert
        assertThrows(EsteCasilleroEstaOcupadoYNoSePuedePonerOtraUnidadException.class,
                ()->{
                    tablero.ubicarUnidadEnCasillero(otroSoldadoDeInfanteria,10,10);
                });

    }
    
    @Test
    public void test04NoSePuedeAgregarUnSoldadoDeInfanteriaEnCasilleroDelSectorEnemigo(){
        //Arrange
        Tablero tablero = Tablero.getInstanciaDeTablero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        //Act y Assert
        assertThrows(NoSePuedeColocarUnaUnidadEnElSectorEnemigoException.class,
                ()->{
                	tablero.ubicarUnidadEnCasillero(soldadoDeInfanteria,19,19);;
                });

    }

    @Test
    public void test05SePuedeRemoverUnSoldadoDeInfanteriaDelTableroYElCasilleroQuedaDesocupado(){
        //Arrange
        Tablero tablero = Tablero.getInstanciaDeTablero();
        SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();

        //Act
        tablero.ubicarUnidadEnCasillero(soldadoDeInfanteria, 3,3);
        tablero.desocuparCasillero(3,3);

        assertThrows(EsteCasilleroYaEstaDesocupadoException.class,
                ()->{
                    tablero.desocuparCasillero(3,3);
                });
    }


}

