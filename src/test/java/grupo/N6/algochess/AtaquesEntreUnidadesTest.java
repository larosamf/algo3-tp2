package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class AtaquesEntreUnidadesTest {
	
	@Test
	public void test01SoldadoDeInfanteriaAtacaAUnaCatapultaYEstaPierde10DeVida() {
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		Catapulta catapulta = new Catapulta();
		
		soldado.atacar(catapulta, 1);
		
		assertEquals(40, catapulta.getVida());
	}
	
	@Test
	public void test02CatapultaNoPuedeSerCuradaPorElCurandero() {
		//Arrange
		Catapulta catapulta = new Catapulta();
		Curandero curandero = new Curandero();
		
		//Act y Assert
        assertThrows(NoSePuedeCurarUnaCatapultaException.class,
                ()->{
                	curandero.curar(catapulta);
                });
	}
	
	@Test
	public void test03SoldadoDeInfanteriaCuradoPorElCuranderoTiene115DeVida() {
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		Curandero curandero = new Curandero();
		
		curandero.curar(soldado);
		
		assertEquals(115, soldado.getVida());
	}
	
	@Test
	public void test04JineteAtacaAUnaCatapultaYEstaPierde5DeVida() {
		Jinete jinete = new Jinete();
		Catapulta catapulta = new Catapulta();
		
		jinete.atacar(catapulta, 1);
		
		assertEquals(45, catapulta.getVida());
	}
	
	@Test
	public void test05CatapultaAtacaAOtraCatapultaYEstaPierde20DeVida() {
		Catapulta catapultaUno = new Catapulta();
		Catapulta catapultaDos = new Catapulta();
		
		catapultaUno.atacar(catapultaDos, 5);
		
		assertEquals(30, catapultaDos.getVida());
	}
}