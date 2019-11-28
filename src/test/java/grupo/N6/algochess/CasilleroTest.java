package grupo.N6.algochess;

import grupo.N6.algochess.exepciones.CasilleroOcupadoException;
import grupo.N6.algochess.exepciones.CasilleroVacioException;
import grupo.N6.algochess.exepciones.FinalException;
import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasilleroTest {

    @Test
    public void test01CasilleroSeCreaConCoordenada() {
    	
    	//Arrange:
        Coordenada coordenada = new Coordenada(1, 1);
        Casillero casillero = new Casillero(coordenada, "Bando1");
        
        //Act y Assert:
        Assert.assertTrue(casillero.estaEnPosicion(coordenada));
    }

    @Test
    public void test02ElCasilleroSeCreaVacio(){

        //Arrange:
        Coordenada coordenada = new Coordenada(1, 1);
        Casillero casillero = new Casillero(coordenada, "Bando1");

        //Act y Assert:
        assertThrows(CasilleroVacioException.class,
                ()->{
                    casillero.obtenerUnidad();
                });
    }

    @Test
    public void test03NoSePuedeOcuparUnCasilleroQueYaEstaOcupado(){

        //Arrange:
        Coordenada coordenada = new Coordenada(1, 1);
        Casillero casillero = new Casillero(coordenada, "Bando1");
        SoldadoDeInfanteria soldadoDeInfanteria1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldadoDeInfanteria2 = new SoldadoDeInfanteria();
        casillero.ponerUnidad(soldadoDeInfanteria1, "Bando1");

        //Act y Assert:
        assertThrows(CasilleroOcupadoException.class,
                ()->{
                    casillero.ponerUnidad(soldadoDeInfanteria2, "Bando1");
                });

    }

    @Test
    public void test04NoSePuedeObtenerUnaUnidadDeUnCasilleroVacio(){
        //Arrange:
        Coordenada coordenada = new Coordenada(1, 1);
        Casillero casillero = new Casillero(coordenada, "Bando1");

        //Act y Assert:
        assertThrows(CasilleroVacioException.class,
                ()->{
                   casillero.obtenerUnidad();
                });

    }

    @Test
    public void test05SeRemueveLaUnidadDeUnCasilleroYQuedaVacio(){
        //Arrange:
        Coordenada coordenada = new Coordenada(1, 1);
        Casillero casillero = new Casillero(coordenada, "Bando1");
        SoldadoDeInfanteria soldadoDeInfanteria1 = new SoldadoDeInfanteria();
        casillero.ponerUnidad(soldadoDeInfanteria1, "Bando1");
        casillero.sacarUnidad();

        //Act y Assert:
        assertThrows(CasilleroVacioException.class,
                ()->{
                    casillero.obtenerUnidad();
                });

    }


}
