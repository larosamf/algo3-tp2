package grupo.N6.algochess;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovilidadDeUnidadesTest {

    @Test
    public void test01SoldadoNoSePuedeMoverAUnCasilleroNoAdyacente() {
        //Arrange
    	Tablero tablero = Tablero.getInstanciaDeTablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(); 
        tablero.ubicarUnidadEnCasillero(soldado,8,8);

        //Act y Assert
        assertThrows(MovimientoInvalidoException.class,
                ()->{
                    soldado.mover(4);
                });
    }
    
   @Test
    public void test02NoSoldadoPuedeMoverseAUnCasilleroNoAdyacente() {
        //Arrange y Act
        Tablero tablero = Tablero.getInstanciaDeTablero();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(); 
        tablero.ubicarUnidadEnCasillero(soldado,9,9);
        
        //Act y Assert
        assertThrows(MovimientoInvalidoException.class,
                ()->{
                	tablero.moverUnidadDePosicionADestino(9,9, 7,7);;
                });
        
    }
    
   @Test
   public void test03SoldadoPuedeMoverseAUnCasilleroAdyacente() {
       //Arrange y Act
       Tablero tablero = Tablero.getInstanciaDeTablero();
       SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(); 
       tablero.ubicarUnidadEnCasillero(soldado,5,5);
       
       //Act 
       tablero.moverUnidadDePosicionADestino(5,5, 5,4);

       //Assert
       assertEquals(soldado, tablero.getUnidadEnCasillero(5,4));
   }
   
   @Test
   public void test04SoldadoNoPuedeMoverseAUnCasilleroAdyacenteOcupado() {
       //Arrange y Act
       Tablero tablero = Tablero.getInstanciaDeTablero();
       SoldadoDeInfanteria soldado = new SoldadoDeInfanteria(); 
       tablero.ubicarUnidadEnCasillero(soldado,3,4);
       SoldadoDeInfanteria soldadoOcupandoPosicionDestino = new SoldadoDeInfanteria(); 
       tablero.ubicarUnidadEnCasillero(soldadoOcupandoPosicionDestino,4,4);
       
       //Act y Assert
       assertThrows(EsteCasilleroEstaOcupadoYNoSePuedePonerOtraUnidadException.class,
               ()->{
               	tablero.moverUnidadDePosicionADestino(3,4, 4,4);;
               });
   }
   
   
}

    